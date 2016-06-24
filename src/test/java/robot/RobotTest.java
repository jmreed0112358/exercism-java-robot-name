package robot;
import org.junit.Test;

import utilities.NameTracker;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

public class RobotTest {

    private static final String EXPECTED_ROBOT_NAME_PATTERN = "[A-Z]{2}\\d{3}";
    private final NameTracker nameTracker = new NameTracker();
    private final Robot robot = new Robot(nameTracker);

    @Test
    public void hasName() {
    	NameTracker nameTracker = new NameTracker();
    	Robot robot = new Robot(nameTracker);
        assertIsValidName(robot.getName());
    }

    @Test
    public void differentRobotsHaveDifferentNames() {
    	NameTracker nameTracker = new NameTracker();
    	Robot robot = new Robot(nameTracker);
        assertThat(robot.getName(), not(equalTo(new Robot(nameTracker).getName())));
    }

    @Test
    public void resetName() {
    	NameTracker nameTracker = new NameTracker();
    	Robot robot = new Robot(nameTracker);
        final String name = robot.getName();
        robot.reset();
        final String name2 = robot.getName();
        assertThat(name, not(equalTo(name2)));
        assertIsValidName(name2);
    }

    private static void assertIsValidName(String name) {
        assertThat(name.matches(EXPECTED_ROBOT_NAME_PATTERN), is(true));
    }
}
