/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vedhax;

/**
 *
 * @author srinivasan
 */
import java.util.*;
import java.io.*;

class NoStock extends Exception {
    public NoStock(String e) {
        super(e);
    }
}

class product implements Serializable {
        public int id;
        String name;
        double cost;
        public int stock;
        product(int a,String b,double c,int d)
                {
                    id=a;
                    name=b;
                    cost=c;
                    stock=d;
                }    
        void display()
        {
          System.out.println("Product Name: "+name+"\nProduct ID: "+id+"\nPrice: "+cost+"\n Stock available: "+stock);
        }   
    }
public class Vedhax {
    static Scanner sc=new Scanner(System.in);
    
    public static void main(String[] args) throws Exception {
        product[] px=new product[10];
        int x=0;
        int i=1;
        System.out.println("----------------------------------------");
        System.out.println("INVENTORY MANAGEMENT SYSTEM");
        System.out.println("----------------------------------------");
        while(i!=5)
        {
            
            System.out.println("1. TO add Item \n 2. To modify the stock \n 3. To delete an Item\n 4. to Display all items\n 5. to Exit");
            System.out.println("ENTER YOUR OPTION: ");
            i=sc.nextInt();
            int a=0,d=0;
            String b="";
            double c=0;
            int id;
            switch(i)
            {
                case 1:
                    System.out.println("\n----------------------------------------");
                    System.out.println("ADD PRODUCT ");
                    System.out.println("----------------------------------------");
                    System.out.println("ENTER THE PRODUCT NAME,id,PRICE AND STOCK: ");
                    b=sc.next();
                    a=sc.nextInt();
                    c=sc.nextDouble();
                    d=sc.nextInt();
                    product p=new product(a,b,c,d);
                    px[x]=p;
                    x++;
                    break;
                case 2:
                    System.out.println("\n----------------------------------------");
                    System.out.println(" MODIFY STOCK ");
                    System.out.println("----------------------------------------");
                    System.out.println("ENTER THE ID OF THE PRODUCT WHOSE STOCK IS TO BE CHANGED: ");
                    id=sc.nextInt();
                    for(int j=0;j<x;j++)
                    {
                        if(px[j].id==id)
                        {
                            int s;
                            System.out.println("ENTER THE STOCK TO BE ADDED: ");
                            s=sc.nextInt();
                            try{
                            if(px[j].stock+s<0)
                                throw new NoStock("NO STOCK");
                            else
                                px[j].stock+=s;
                                }
                            catch(Exception e)
                            {
                                System.out.println(e);
                            }
                         
                        }
                    }
                    break;
                case 3:
                    System.out.println("\n----------------------------------------");
                    System.out.println(" DELETE PRODUCT");
                    System.out.println("----------------------------------------");
                    System.out.println("ENTER THE ID to Be Deleted: ");
                    id=sc.nextInt();
                    for(int j=0;j<x;j++)
                    {
                        if(px[j].id==id) 
                        {  
                        px[j]=null;   
                        System.out.println("Record Deleted ");
                        }
                    }
                    break;
                case 4:
                    System.out.println("\n----------------------------------------");
                    System.out.println(" DISPLAY PRODUCT ");
                    System.out.println("----------------------------------------");
                    for(int j=0;j<x;j++)
                    {
                        if(px[j]!=null)
                        {
                            System.out.println("Product "+(i+1));
                            px[j].display();
                            System.out.println(" ");
                        }
                    }
                    break;        
            }
            System.out.println("----------------------------------------");
        }
        
    }
    
}
