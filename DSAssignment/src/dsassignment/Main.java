package dsassignment;

import java.util.Scanner;

public class Main {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int option;
        do {

            Menu();

            option = input.nextInt();

            switch (option) {
                case 1:
                    mergeLists();
                    break;

                case 2:
                    mergeStacks();
                    break;

                case 3:
                    mergeQueues();
                    break;

                case 4:
                    mergeListStack();
                    break;

                case 5:
                    mergeListQueue();
                    break;
                case 6:
                    mergeListStackQueue();
                    break;
                case 7:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid Selection!");
            }

        } while (option != 7);

    }

    public static void Menu() {
        System.out.print("** Welcome to the Data structure Merging Assignment** \n"
                + "1:Merging two Single Linked List data structure type\n"
                + "2:Merging two Stacks data structure type\n"
                + "3:Merging two Queses data structure type\n"
                + "4:Merging Single Linked List with Stack to Linked List\n"
                + "5:Merging Single Linked List with Queue to Linked List\n"
                + "6:Merging Singly Linked List with Stack only Patient’s name that start with S to Queue\n"
                + "7:Exit\n"
                + "Your selection is: ");
    }

    /*-------------------------------------------------------------------------
       LinkedList
     */
    public static SinglyLinkedList<PatientInfo> mergeLists() {
        SinglyLinkedList<PatientInfo> firstList = readPatients();
        SinglyLinkedList<PatientInfo> secondList = readPatients();
        SinglyLinkedList<PatientInfo> mergedList = new SinglyLinkedList<>();
        System.out.println("-------Lists Before Merging-------");
        System.out.println("The First Given Linked List:");
        firstList.print();
        System.out.println("The Second Given Linked List:");
        secondList.print();
        
        while (!firstList.isEmpty() || !secondList.isEmpty()) {
            if (!firstList.isEmpty()) {
                PatientInfo patient = firstList.removeFirst();
                mergedList.addLast(patient);
            }
            if (!secondList.isEmpty()) {
                PatientInfo patient = secondList.removeFirst();
                mergedList.addLast(patient);
            }
        }
        System.out.println("-------List After Merging-------");
        mergedList.print();
       
        return mergedList;
    }
    
    private static SinglyLinkedList<PatientInfo> readPatients() {
        System.out.print("Please enter the linked list size: ");
        int size = input.nextInt();
        SinglyLinkedList<PatientInfo> list = new SinglyLinkedList<>();
        System.out.println("Please enter " + size + " patients info: ");
        for (int i = 0; i < size; i++) {
            System.out.print("Enter patient #" + (i + 1) + " id: ");
            int patientId = input.nextInt();
            input.nextLine();
            System.out.print("Enter patient #" + (i + 1) + " name: ");
            String patientName = input.nextLine();
            PatientInfo patient = new PatientInfo();
            patient.setPatientID(patientId);
            patient.setPatientName(patientName);
            list.addLast(patient);
        }
        return list;
    }
    

    /*-------------------------------------------------------------------------
       Stack
     */
    public static void mergeStacks() {
        // first stack
        System.out.print("Please enter the first stack size: ");
        int firstSize = input.nextInt();
        LLStack<PatientInfo> firstStack = new LLStack<>();
        System.out.println("Please enter " + firstSize + " patients info: ");
        for (int i = 0; i < firstSize; i++) {
            PatientInfo patient = getPatientInfo();
            firstStack.push(patient);
        }

        // second stack
        System.out.print("Please enter the second stack size: ");
        int secondSize = input.nextInt();
        LLStack<PatientInfo> secondStack = new LLStack<>();
        System.out.println("Please enter " + secondSize + " patients info: ");
        for (int i = 0; i < secondSize; i++) {
            PatientInfo patient = getPatientInfo();
            secondStack.push(patient);
        }
         // print
         System.out.println("-------Stacks Before Merging-------");

         System.out.println("The First given Stack:");
         firstStack.print();
 
         System.out.println("The Second given Stack:");
         secondStack.print();
 

        // merge
        LLStack<PatientInfo> mergedStack = new LLStack<>();
        while(!firstStack.isEmpty()) {
            PatientInfo patient = firstStack.pop();
            mergedStack.push(patient);
        }
        while(!secondStack.isEmpty()) {
            PatientInfo patient = secondStack.pop();
            mergedStack.push(patient);
        }
       
        System.out.println("-------Stack After Merging-------");
        mergedStack.print();
}

private static PatientInfo getPatientInfo() {
        System.out.print("Enter patient id: ");
        int patientId = input.nextInt();
        input.nextLine();
        System.out.print("Enter patient name: ");
        String patientName = input.nextLine();
        PatientInfo patient = new PatientInfo();
        patient.setPatientID(patientId);
        patient.setPatientName(patientName);
        return patient;
    }


    /*-------------------------------------------------------------------------
       Queue
     */
    public static void mergeQueues() {

        // first queue
        System.out.print("Please enter the first queue size: ");
        int firstSize = input.nextInt();
        LLQueue<PatientInfo> firstQueue = new LLQueue<>();
        System.out.println("Please enter " + firstSize + " patients info: ");
        for (int i = 0; i < firstSize; i++) {
            System.out.print("Enter patient #" + (i + 1) + " id: ");
            int patientId = input.nextInt();
            input.nextLine();
            System.out.print("Enter patient #" + (i + 1) + " name: ");
            String patientName = input.nextLine();
            PatientInfo patient = new PatientInfo();
            patient.setPatientID(patientId);
            patient.setPatientName(patientName);
    
            firstQueue.enqueue(patient);
        }
    
        // second queue
        System.out.print("Please enter the second queue size: ");
        int secondSize = input.nextInt();
        LLQueue<PatientInfo> secondQueue = new LLQueue<>();
        System.out.println("Please enter " + secondSize + " patients info: ");
        for (int i = 0; i < secondSize; i++) {
            System.out.print("Enter patient #" + (i + 1) + " id: ");
            int patientId = input.nextInt();
            input.nextLine();
            System.out.print("Enter patient #" + (i + 1) + " name: ");
            String patientName = input.nextLine();
            PatientInfo patient = new PatientInfo();
            patient.setPatientID(patientId);
            patient.setPatientName(patientName);
    
            secondQueue.enqueue(patient);
        }
        System.out.println("-------Queues Before Merging-------");
    
        System.out.println("The First given Queue:");
        firstQueue.print();
    
        System.out.println("The Second given Queue:");
        secondQueue.print();
    
        // merge
        LLQueue<PatientInfo> mergedQueue = new LLQueue<>();
    
        // copy first
        while(!firstQueue.isEmpty()) {
            PatientInfo patient = firstQueue.dequeue();
            mergedQueue.enqueue(patient);
        }
    
        // copy second
        while(!secondQueue.isEmpty()) {
            PatientInfo patient = secondQueue.dequeue();
            mergedQueue.enqueue(patient);
        }
    

    
        System.out.println("-------Queue After Merging-------");
        mergedQueue.print();
    }
    
    /*-------------------------------------------------------------------------
       LinkedList with Stack
     */
    public static void mergeListStack() {
        SinglyLinkedList<PatientInfo> list = readPatientsFromUser("linked list", input);
        LLStack<PatientInfo> stack = readPatientsFromStack("stack", input);
        SinglyLinkedList<PatientInfo> mergedList = new SinglyLinkedList<>();
        
        System.out.println("-------List and Stack Before Merging-------");
        System.out.println("The Given Linked List:");
        list.print();
        System.out.println("The Given Stack:");
        stack.print();
        // copy list
        for (int i = 0; i < list.size(); i++) {
            PatientInfo patient = list.removeFirst();
            list.addLast(patient);
            mergedList.addLast(patient);
        }
    
        // copy stack
        
        LLStack<PatientInfo> temp = new LLStack<>();
        while (!stack.isEmpty()) {
            PatientInfo patient = stack.pop();
            temp.push(patient);
        }
        
        while (!temp.isEmpty()) {
            PatientInfo patient = temp.pop();
            mergedList.addLast(patient);
            stack.push(patient);
        }
        // print
       
        System.out.println("-------List After Merging-------");
        mergedList.print();
    }
    
    private static SinglyLinkedList<PatientInfo> readPatientsFromUser(String listName, Scanner input) {
        System.out.print("Please enter the " + listName + " size: ");
        int listSize = input.nextInt();
        SinglyLinkedList<PatientInfo> list = new SinglyLinkedList<>();
        System.out.println("Please enter " + listSize + " patients info: ");
    
        for (int i = 0; i < listSize; i++) {
            System.out.print("Enter patient #" + (i + 1) + " id: ");
            int patientId = input.nextInt();
            input.nextLine();
            System.out.print("Enter patient #" + (i + 1) + " name: ");
            String patientName = input.nextLine();
            PatientInfo patient = new PatientInfo();
            patient.setPatientID(patientId);
            patient.setPatientName(patientName);
    
            // add to list
            list.addLast(patient);
        }
        return list;
    }
    
    private static LLStack<PatientInfo> readPatientsFromStack(String stackName, Scanner input) {
        System.out.print("Please enter the " + stackName + " size: ");
        int stackSize = input.nextInt();
        LLStack<PatientInfo> stack = new LLStack<>();
        System.out.println("Please enter " + stackSize + " patients info: ");
        for (int i = 0; i < stackSize; i++) {
            System.out.print("Enter patient #" + (i + 1) + " id: ");
            int patientId = input.nextInt();
            input.nextLine();
            System.out.print("Enter patient #" + (i + 1) + " name: ");
            String patientName = input.nextLine();
            PatientInfo patient = new PatientInfo();
            patient.setPatientID(patientId);
            patient.setPatientName(patientName);
    
            // add to stack
            stack.push(patient);
        }
        return stack;
    }
    
    /*-------------------------------------------------------------------------
       LinkedList with Queue
     */
    public static void mergeListQueue() {
        // list
        System.out.print("Please enter the linked list size: ");
        int listSize = input.nextInt();
        SinglyLinkedList<PatientInfo> list = new SinglyLinkedList<>();
        System.out.println("Please enter " + listSize + " patients info: ");

        // read linked list patients from the user(based on size)
        for (int i = 0; i < listSize; i++) {
            System.out.print("Enter patient #" + (i + 1) + " id: ");
            int patientId = input.nextInt();
            input.nextLine();
            System.out.print("Enter patient #" + (i + 1) + " name: ");
            String patientName = input.nextLine();
            PatientInfo patient = new PatientInfo(patientId, patientName);
            list.addLast(patient);
        }

        // queue
        System.out.print("Please enter the queue size: ");
        int queueSize = input.nextInt();
        LLQueue<PatientInfo> queue = new LLQueue<>();
        System.out.println("Please enter " + queueSize + " patients info: ");
        for (int i = 0; i < queueSize; i++) {
            System.out.print("Enter patient #" + (i + 1) + " id: ");
            int patientId = input.nextInt();
            input.nextLine();
            System.out.print("Enter patient #" + (i + 1) + " name: ");
            String patientName = input.nextLine();
            PatientInfo patient = new PatientInfo(patientId, patientName);
            queue.enqueue(patient);
        }
  // print
  System.out.println("-------List and Queue Before Merging-------");
  System.out.println("The Given Linked List:");
  list.print();

  System.out.println("The Given Queue:");
  queue.print();
        // merge List
        SinglyLinkedList<PatientInfo> mergedList = new SinglyLinkedList<>();
        // copy list
        for (int i = 0; i < listSize; i++) {
            PatientInfo patient = list.removeFirst();
            list.addLast(patient);
            mergedList.addLast(patient);
        }
        // copy queue
        for (int i = 0; i < queueSize; i++) {
            PatientInfo patient = queue.dequeue();
            queue.enqueue(patient);
            mergedList.addLast(patient);
        }
      

        System.out.println("-------List After Merging-------");
        mergedList.print();
    }

    /*-------------------------------------------------------------------------
       LinkedList with Stack to Queue
     */
    public static void mergeListStackQueue() {
        // list
        System.out.print("Please enter the linked list size: ");
        int listSize = input.nextInt();
        SinglyLinkedList<PatientInfo> list = new SinglyLinkedList<>();
        System.out.println("Please enter " + listSize + " patients info: ");
    
        // read linked list patients from the user(based on size)
        for (int i = 0; i < listSize; i++) {
            System.out.print("Enter patient #" + (i + 1) + " id: ");
            int patientId = input.nextInt();
            input.nextLine();
            System.out.print("Enter patient #" + (i + 1) + " name: ");
            String patientName = input.nextLine();
            PatientInfo patient = new PatientInfo();
            patient.setPatientID(patientId);
            patient.setPatientName(patientName);
    
            // add to list
            list.addLast(patient);
        }
    
        // stack
        System.out.print("Please enter the stack size: ");
        int stackSize = input.nextInt();
        LLStack<PatientInfo> stack = new LLStack<>();
        System.out.println("Please enter " + stackSize + " patients info: ");
        for (int i = 0; i < stackSize; i++) {
            System.out.print("Enter patient #" + (i + 1) + " id: ");
            int patientId = input.nextInt();
            input.nextLine();
            System.out.print("Enter patient #" + (i + 1) + " name: ");
            String patientName = input.nextLine();
            PatientInfo patient = new PatientInfo();
            patient.setPatientID(patientId);
            patient.setPatientName(patientName);
    
            // add to stack
            stack.push(patient);
        }
        System.out.println("-------List and Stack Before Merging-------");
        System.out.println("The Given Linked List:");
        list.print();
    
        System.out.println("The Given Stack:");
        stack.print();
    
        // merge
        LLQueue<PatientInfo> mergedQueue = new LLQueue<>();
    
        // copy list
        for (int i = 0; i < listSize; i++) {
            PatientInfo patient = list.removeFirst();
            char firstLetter = patient.getPatientName().toUpperCase().charAt(0);
            if (firstLetter == 'S') {
                mergedQueue.enqueue(patient);
            }
        }
    
        // copy stack
        while (!stack.isEmpty()) {
            PatientInfo patient = stack.pop();
            char firstLetter = patient.getPatientName().toUpperCase().charAt(0);
            if (firstLetter == 'S') {
                mergedQueue.enqueue(patient);
            }
        }
    
        // print
       
    
        System.out.println("-------Queue After Merging Patients Start with Letter S-------");
        mergedQueue.print();
    }
    
}
