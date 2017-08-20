package javatpoint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by acedric on 14/02/2017.
 */
public class Operation {
    int data = 50;

    void change(Operation op){
        op.data=op.data+100;
    }

    public static void main(String[] args) {
//        Operation op = new Operation();
//        System.out.println(op.data);
//        op.change(op);
//        System.out.println(op.data);
//
//        ArrayList<String> al = new ArrayList();
//        al.add("arnaud");
//        al.add("arnaud1");
//        al.add("arnaud2");
//        al.add("arnaud3");
//
//
//        Iterator<String> iterator = al.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }

        Employee employee1 = new Employee(1,"arnaud","catford");
        Employee employee2 = new Employee(2,"daryl","Lewisham");
        Employee employee3 = new Employee(3,"fabrice","clayton");


        ArrayList<Employee> emp = new ArrayList();
        emp.add(employee1);
        emp.add(employee2);
        emp.add(employee3);
        Iterator itr = emp.iterator();
        while (itr.hasNext()){
            Employee epl = (Employee) itr.next();
            System.out.println(epl.getEmployeeId() +" "+ epl.getEmployeeName() +" "+epl.getEmployeeAddress());
//            System.out.println(itr.next());
        }
        Map<Integer,String> hm = new HashMap();
        hm.put(1,"arnaud");
        hm.put(2,"cedric");
        hm.put(3,"daryl");
        hm.put(1,"arnaud");
        for (Map.Entry m:hm.entrySet()) {
            System.out.println(m.getKey()+" : "+ m.getValue());
        }

    }
}
class Employee{
    private int employeeId;
    private String employeeName;
    private String employeeAddress;


    public Employee(int employeeId, String employeeName, String employeeAddress) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeAddress = employeeAddress;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }
}
