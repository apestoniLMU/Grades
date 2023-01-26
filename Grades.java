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

    public double average() {
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
            String line = (i*10) + "-" + String.format("%.2f",((i*10)+9.99)) + ":";
            String s = "*";
            line = line + (s.repeat(groups[i]));
            System.out.println(line);
        }
    }

    public int[] getGroups() {
        int[] groups = {0,0,0,0,0,0,0,0,0,0};
        for(int i=0; i<gradesList.length; i++) {
            int index = ((int) Math.floor((((gradesList[i])/10))))-1;
            if(index<0) {
                index = 0;
            } else if(index>9) {
                index = 9;
            }
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
            String line = scanner.nextLine();
            int grade = 0;
            try {
                grade = Integer.parseInt(line);
            } catch(Exception e) {
                System.out.println("Invalid Text. Please Input a Number");
            }
            array[i] = grade;
        }

        Grades grades = new Grades(array);
        System.out.println("---------------------");
        System.out.println("Highest:" + grades.highest());
        System.out.println("Lowest: " + grades.lowest());
        System.out.println("Number of Grades: " + grades.getNumGrades());
        System.out.println("Average: " + grades.average());
        System.out.println("Number of failing grades: " + grades.numOfFailingGrades(50));
        grades.histogram();
        scanner.close();
    }
}