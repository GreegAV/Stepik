package Stepik;


import java.util.concurrent.ThreadLocalRandom;


public class RobotApp {

    public static class Robot {
        private int x;
        private int y;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public Robot(int x, int y) {

            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args) {
        new RobotApp().moveRobot(new RobotConnectionManagerImpl(), 10, 10);
    }


    public static void moveRobot(RobotConnectionManager connectionManager, int toX, int toY){
        int tryCounter = 1;
        boolean isDone = false;
        while (tryCounter < 4 && !isDone){
            try(RobotConnection connection = connectionManager.getConnection()) {
                connection.moveRobotTo(toX, toY);
                isDone = true;
            } catch (RobotConnectionException ex){
                System.out.println(tryCounter + " try...");
                tryCounter++;
            }
        }
        if (isDone){
            return;
        } else {
            throw new RobotConnectionException("Looser!");
        }
    }

    public interface RobotConnection extends AutoCloseable {
        @Override
        void close() throws RobotConnectionException;

        void moveRobotTo(int x, int y) throws RobotConnectionException;
    }

    public static class RobotConnectionException extends RuntimeException {
        public RobotConnectionException(String message) {
            super(message);
        }

        public RobotConnectionException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static class RobotConnectionImpl implements RobotConnection {

        private Robot robot;

        public RobotConnectionImpl(Robot robot) {
            this.robot = robot;
        }

        @Override
        public void moveRobotTo(int x, int y) throws RobotConnectionException {
            int random = ThreadLocalRandom.current().nextInt(1, 3);
            if (random % 2 == 0) {
                throw new RobotConnectionException("The connection suddenly interrupted...");
            }
            System.out.println("Robot move from: [" + robot.getX() + ";" + robot.getY() + "] to "
                    + "[" + x + ";" + y + "]");
            robot.setX(x);
            robot.setY(y);
        }

        @Override
        public void close() throws RobotConnectionException {
            int random = ThreadLocalRandom.current().nextInt(1, 3);
            if (random % 2 == 0) {
                throw new RobotConnectionException("Connection can not be closed...");
            }
            System.out.println("Trying to close the connection... Random: " + random);
            robot = null;
        }

    }

    public interface RobotConnectionManager {
        RobotConnection getConnection() throws RobotConnectionException;
    }

    public static class RobotConnectionManagerImpl implements RobotConnectionManager {
        @Override
        public RobotConnection getConnection() throws RobotConnectionException {
            int random = ThreadLocalRandom.current().nextInt(1, 21);
            if (random % 2 == 0) {
                throw new RobotConnectionException("The connection can not be established.");
            }
            System.out.println("Trying to establish connection...");
            System.out.println("Random = " + random);
            System.out.println("Connection successfully establish...");
            return new RobotConnectionImpl(new Robot(0, 0));
        }
    }

}
