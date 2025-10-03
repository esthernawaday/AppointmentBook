public class Appointmentbook {
    private boolean[][] schedule;

    public Appointmentbook(boolean[][] schedule) {
        this.schedule = schedule;
    }

    private boolean isMinuteFree(int period, int minute) {
        return schedule[period - 1][minute];
    }

    public int findFreeBlock(int period, int duration) {
        int block = 0;
        for (int i = 0; i < 60; i++)
            if (isMinuteFree(period, i)) {
                block++;
                if (block == duration)
                    return i - duration + 1;
            }
        else block = 0;
        return -1;
    }


    public boolean makeAppointment(int startPeriod, int endPeriod, int duration) {
        schedule = new boolean[8][60];
        for(int i = 25; i < 30; i++) schedule[1][i] = true;
        for(int i = 0; i < 15; i++) schedule[2][i] = true;
        for(int i = 41; i < 60; i++) schedule[2][i] = true;
        for(int i = 5; i < 30; i++) schedule[3][i] = true;
        for(int i = 44; i < 60; i++) schedule[3][i] = true;
        return false;

    }

    public void printPeriod(int period) {
        for (int i = 0; i < schedule[period - 1].length; i++)
            System.out.println(i + " " + schedule[period - 1][i]);
    }
    public boolean reserveBlock(int startMinute, int duration, int period) {
        for(int i = startMinute; i< startMinute + duration; i++) {
            schedule[period - 1][i] = false;
            int freeBlock = findFreeBlock(i, duration);
            if (freeBlock > -1) {
                reserveBlock(i, freeBlock, duration);
                return true;
            }
        }
        return false;
    }
}