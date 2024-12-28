package com.mobile.interactions;

import com.mobile.exceptions.AutomationException;
import com.mobile.utils.Direction;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;

import static com.mobile.utils.AppsUtils.*;
import static com.mobile.utils.Constants.PACKAGE_NAME;

public class Gestures {

    private static void performGesture(int startX, int startY, int endX, int endY, int speed) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()))
                .addAction(finger.createPointerMove(Duration.ofSeconds(speed), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
        getMobileDriver().perform(Collections.singletonList(sequence));
    }

    public static Performable scrollByDirectionIn(Target scrollTarget, Direction direction, double distance) {
        return Task.where(actor -> {
            WebElementFacade scrollRect = scrollTarget.resolveFor(actor);
            if (distance < 0 || distance > 1) {
                throw new AutomationException("Scroll distance should be between 0 and 1");
            }
            int speed = 1;
            Dimension dimension = scrollRect.getSize();
            Point coordinates = new Point(scrollRect.getLocation().getX(), scrollRect.getLocation().getY());
            Point midPoint = new Point((int) (coordinates.x + dimension.width * 0.5), (int) (coordinates.y + dimension.height * 0.5));
            int top = midPoint.y - (int) ((dimension.height * 0.5) * distance);
            int bottom = midPoint.y + (int) ((dimension.height * 0.5) * distance);
            int left = midPoint.x - (int) ((dimension.width * 0.5) * distance);
            int right = midPoint.x + (int) ((dimension.width * 0.5) * distance);
            switch (direction) {
                case UP -> performGesture(midPoint.x, top, midPoint.x, bottom, speed);
                case DOWN -> performGesture(midPoint.x, bottom, midPoint.x, top, speed);
                case LEFT -> performGesture(left, midPoint.y, right, midPoint.y, speed);
                case RIGHT -> performGesture(right, midPoint.y, left, midPoint.y, speed);
            }
        });
    }

    public static Performable clickAndHoldToElement(Target sourceElement, Target targetElement) {
        return Task.where(actor -> {
            WebElementFacade fromElement = sourceElement.resolveFor(actor);
            WebElementFacade toElement = targetElement.resolveFor(actor);
            Actions actionProvider = new Actions(getMobileDriver());
            actionProvider.clickAndHold(fromElement).moveToElement(toElement).build().perform();
            actionProvider.release().build().perform();
        });
    }

    public static Performable useDeeplink(String url) {
        return Task.where(actor -> {
            HashMap<String, String> map = new HashMap<>();
            map.put("url", url);
            map.put("package", PACKAGE_NAME);
            getAndroidDriver().executeScript("mobile: deepLink", map);
        });
    }
}