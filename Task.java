
// Console-based Task Manager to add, view, complete, and delete tasks.
package myclasses;
import java.util.Scanner;
import java.util.ArrayList;
public class Task
{
    
    private  int id;
    private String task;
    private String desc;
    private boolean isComplete;
    private static int chid=1;
    
    //Constructor to initialize task with unique ID, name, and description.
    public Task(String task,String desc)
    {
        this.id=chid++;
        this.task=task;
        this.desc=desc;
        this.isComplete=false;
    }
    
    //Displays task details.
    public void display()
    {
        System.out.println("Task Id : "+id);
        System.out.println("Task : "+task);
        System.out.println("Description : "+desc);
        System.out.println("Task Complete Status : "+(isComplete? "Complete" : "InComplete"));
        System.out.println("----------------------------------");
       
    }
    
    //Marks this task as complete.
    public void complete()
    {
        isComplete=true;
    }
    
    // Returns the ID of the task.
    public int getId()
    {
        return  id;
    }
    
    public void settask(String task,String desc)
    {
        this.task=task;
        this.desc=desc;
    }
    
    public static void main(String[] args)
    {
        
         //Main menu-driven logic for task manager.
        Scanner sc =new Scanner(System.in);
        int choice;
        
        ArrayList<Task> tasklist=new ArrayList<>();
      
        do
        {
        System.out.println("----------------------List Menu-------------------------");
        System.out.println("1. Add Task");
        System.out.println("2. View All Tasks");
        System.out.println("3. Mark Task As complete");
        System.out.println("4. Delete Task");
        System.out.println("5. Update Task");
        System.out.println("6. Exit");
        System.out.println("--------------------------------------------------------");
        System.out.println("Enter Your Choice : ");
        choice=sc.nextInt();
        sc.nextLine();
        
        switch(choice)
        {
            case 1:
            {
                System.out.println("Enter task : ");
                String task=sc.nextLine();
                System.out.println("Enter full description : ");
                String desc=sc.nextLine();
                
                tasklist.add(new Task( task,desc));
                break;
            }
            case 2:
            {
                if(tasklist.isEmpty())
                {
                    System.out.println("List is Empty");
                }
                else
                {
                    System.out.println("Your All Tasks");
                  
                    for(Task x:tasklist)
                    {
                        x.display();
                    }
                }
                break;
            }
            case 3:
            {
               if(tasklist.isEmpty())
               {
                   System.out.println("List is Empty");
               }
               else
               {
                    System.out.println("Enter Task Id  to Mark As Complete!");
                int id=sc.nextInt();
                boolean flag=false;
                
               
                for(Task x:tasklist)
                {
                    if(x.getId()==id)
                    {
                      x.complete();
                        System.out.println("Successfully Marked As Complete!");
                        flag=true;
                        break;
                    }
                    
                }
                if(!flag)
                {
                    System.out.println("Task Not Found");
                }
               }    
                
              break; 
            }
            case 4:
            {
                if(tasklist.isEmpty())
                {
                    System.out.println("List is Empty");
                }
                else
                {
                    System.out.println("Enter Task Id do you want to delete");
                    int id=sc.nextInt();
                    Task t=null;
                            
                    for(Task m:tasklist)
                    {
                        if(m.getId()==id)
                        {
                            t=m;
                            break;
                        }
                        
                    }
                      if(t!=null)
                      {
                          tasklist.remove(t);
                          System.out.println("Task deleted successfully! ");  
                      }
                      else
                      {
                          System.out.println("Task Not Found");
                      }
                }
                break;
            }
            
            case 5:
            {
                System.out.println("Enter Task Id do you want to Update");
                int id=sc.nextInt();
                
                //to clear buffer
                sc.nextLine();
                boolean found=false;
                for(Task tk:tasklist )
                {
                    if(tk.getId()==id)
                    {
                        System.out.println("Enter New Task");
                        String newTask=sc.nextLine();
                        System.out.println("Enter New Description");
                        String newdesc=sc.nextLine();
                        tk.settask(newTask, newdesc);
                        System.out.println("Task Update Successfully!");
                        found=true;
                        break;
                    }
                   
                }
                if(!found)
                {
                    System.out.println("Not Found");
                }
                
                break;
            }
            case 6:break;
             
        }
    }  while(choice!=5); 
}        
        
}   

