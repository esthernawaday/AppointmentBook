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
}