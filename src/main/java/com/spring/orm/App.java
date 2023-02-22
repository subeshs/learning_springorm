package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.enitites.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context= new  ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
//        Student s= new Student(153, "subesh","delhi");
//        int r = studentDao.insert(s);
//        System.out.println("done"+r);
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       
        boolean go=true;
        while(go) {
        	 System.out.println("PRESS 1 for add new student");
             System.out.println("PRESS 2 display all student");
             System.out.println("PRESS 3 for get details of single student");
             System.out.println("PRESS 4 for delete student");
             System.out.println("PRESS 5 for update student");
             System.out.println("press 6 for exit");
             try {
            	 int input = Integer.parseInt(br.readLine());
//            	 if(input==1) {
//            		 
//            	 }else if() {
//            		 
//            	 }
            	 switch (input) {
					case 1:
						//add a new studnet
						//taking input from user
						System.out.println("enter user id");
						int uId = Integer.parseInt(br.readLine());
						System.out.println("enter user name");
						String uName=br.readLine();
						System.out.println("enter user city");
						String uCity=br.readLine();
						
						//creating object student
						Student s=new Student(uId, uName,uCity);
						//saving studnet in studnet dao
						int r = studentDao.insert(s);
						System.out.println(r + " this added");
						System.out.println("***************************************************");
						System.out.println();
						
						break;
					case 2 :
						//display all
						System.out.println("************************");
						List<Student> allStudent = studentDao.getAllStudent();
						for(Student st:allStudent) {
							System.out.println("id :" +st.getStudentId());
							System.out.println("Name :" + st.getName());
							
							System.out.println("city : "+ st.getCity());
							System.out.println("______________________");
							
						}
						System.out.println("*************************");
						break;
					case 3:
						//get details of single student
						System.out.println("*************************");
						System.out.println("enter student id");
						int userId = Integer.parseInt(br.readLine());
						Student st = studentDao.getStudent(userId);
						
						//printing student details
						System.out.println("id :" +st.getStudentId());
						System.out.println("Name :" + st.getName());
						
						System.out.println("city : "+ st.getCity());
						System.out.println("______________________");
						break;
					case 4:
						//delete
						System.out.println("*************************");
						System.out.println("enter student id");
						int Id = Integer.parseInt(br.readLine());
						studentDao.delete(Id);
						System.out.println("delete complete");
						System.out.println("______________________");
						break;
					case 5 :
						//update
						System.out.println("*************************");
						System.out.println("enter user id");
						int usId = Integer.parseInt(br.readLine());
						System.out.println("enter user name");
						String usName=br.readLine();
						System.out.println("enter user city");
						String usCity=br.readLine();
						//creating object student
						Student us=new Student(usId, usName,usCity);
						//saving studnet in studnet dao
						studentDao.updateStudent(us);
						System.out.println(" this updated");
						System.out.println("***************************************************");
						System.out.println();
						break;
					case 6:
						// exit;
						go=false;
						break;
				}
            	 
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("invalid input enter another ");
				System.out.println(e.getMessage());
			}
        }

        System.out.println("thanks for using app");
        
        
    }
}
