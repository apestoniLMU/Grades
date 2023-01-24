import java.util.Scanner;

public class Grades {
    private int[] gradesList;

    public Grades(){};

    public Grades(int[] list) {
        this.gradesList = list;
    }

    public int[] getValues() {
        return gradesList;
    }

    public void setValues(int[] list) {
        this.gradesList = list;
    }
    
    public int highest() {
        int highest = -1;
        for(int i=0; i<gradesList.length; i++) {
            if(gradesList[i]>highest) {
                highest = gradesList[i];
            }
        } return highest;
    }
    
    public int lowest() {
        int lowest = 101;
        for(int i=0; i<gradesList.length; i++) {
            if(gradesList[i]<lowest) {
                lowest = gradesList[i];
            }
        }

        if(lowest==101) {
            return -1;
        } return lowest;
    }

    public int getNumGrades() {
        return gradesList.length;
    }

    public int average() {
        int sum = 0;
        for(int i=0; i<gradesList.length; i++) {
            sum+=gradesList[i];
        } return (sum/gradesList.length);
    }

    public int numOfFailingGrades(int lowBar) {
        int count = 0;
        for(int i=0; i<gradesList.length; i++) {
            if(gradesList[i]<=lowBar) {
                count++;
            }
        } return count;
    }

    public void histogram() {
        int[] groups = getGroups();
        for(int i=0; i<groups.length; i++) {
            String line = (i*10) + "-" + ((i*10)+9) + ":";
            String s = "*";
            line = line + (s.repeat(groups[i]*2));
            System.out.println(line);
        }
    }

    public int[] getGroups() {
        int[] groups = {0,0,0,0,0,0,0,0,0,0};
        for(int i=0; i<gradesList.length; i++) {
            int index = ((int) Math.floor((((gradesList[i])/10))))-1;
            groups[index]+=1;
        } return groups;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many grades would you like to add?");
        int size = Integer.parseInt(scanner.nextLine());
        int[] array = new int[size];
        for(int i=0; i<array.length; i++) {
            System.out.println("Enter grade " + (i+1) + ":");
            int grade = Integer.parseInt(scanner.nextLine());
            array[i] = grade;
        }

        Grades grades = new Grades(array);
        System.out.println("---------------------");
        System.out.println(grades.highest());
        System.out.println(grades.lowest());
        System.out.println(grades.getNumGrades());
        System.out.println(grades.average());
        System.out.println(grades.numOfFailingGrades(50));
        grades.histogram();
        scanner.close();
    }
}