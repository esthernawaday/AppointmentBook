import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)  throws IOException{
        System.out.println(read());
        boolean[][] schedule = new boolean[8][60];
        Appointmentbook a = new Appointmentbook(schedule);
        for (int i = 30; i < 45; i++) schedule[1][i] = true;
        a.printPeriod(2);
        a.findFreeBlock(2, 15);
        Appointmentbook b = new Appointmentbook(schedule);
        int period = 2;
        while (period < 5) {
            System.out.println("Period: " + period);
            b.printPeriod(period);
            period++;
        }
        b.printPeriod(4);
        System.out.println(b.makeAppointment(2, 4, 22));
        b.printPeriod(4);
    }
    public static int read() throws FileNotFoundException{
        int meetings = 0;
        File f = new File("Schedules.txt");
        Scanner s = new Scanner(f);
        String schedule = "";
        while (s.hasNext()){
            while (s.hasNextBoolean()){
                schedule += s.nextBoolean() + "";
            }
            Appointmentbook a = new Appointmentbook(readSchedule(schedule));
            if (a.makeAppointment(s.nextInt(), s.nextInt(), s.nextInt())){
                meetings++;
            schedule = "";
        }
        }
        return meetings;
    }
    public static boolean[][] readSchedule(String lines){
        Scanner s = new Scanner(lines);
        boolean[][] schedule = new boolean[8][60];
        for (int i = 0; i < schedule.length; i++){
            for (int j = 0; j < schedule[i].length; j++){
                schedule[i][j] = s.nextBoolean();
            }
        }
        return schedule;
    }
    }