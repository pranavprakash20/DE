import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Differential_Evolution extends JPanel
{
    private JRadioButton de;
    private JRadioButton de_evo;
    private JComboBox var;
    private JComboBox fun;
    private JMenuBar menu;
    private JLabel jcomp6;
    private JLabel jcomp7;
    private JTextField np_val;
    private JLabel jcomp9;
    private JTextField cr_val;
    private JLabel jcomp11;
    private JTextField d_val;
    private JLabel jcomp13;
    private JLabel jcomp14;
    private JTextField gen_val;
    private JCheckBox mov;
    private JCheckBox avg_g;
    private JCheckBox stdevn;
    private JCheckBox speed;
    private JCheckBox qm;
    private JCheckBox graph;
    private JCheckBox test;
    private JCheckBox qt;
    private JCheckBox pop_var;
    private JButton run;
    private static int click1 = 0,click2 = 0;
    private String n1,n2,n3,n4;
    private JLabel lab1;
    private JLabel lab2;
    private JLabel lab3;
    private JLabel lab4;
    private JLabel lab5;
    private JLabel t1;
    private JLabel t2;
    private JLabel t3;
    private JLabel t4;
    private JLabel t5;
    private JButton graph1;
    private JButton graph2;
    private JLabel lab6;
    private JLabel t6;
    private JLabel lab7;
    private JLabel t7;
    private JLabel labforgraph;
    private JLabel p1;
    private JLabel p11;
    private JLabel p2;
    private JLabel p22;
    private JLabel p3;
    private JLabel per;
    private JLabel per_v;
    private JLabel p33;
    private JLabel head;
    
    
    private static String[] arg;

	
	final static JFrame frame = new JFrame ("gui");
	
	public static void pass(String[] a)
	{
		arg = a;
	}
	
   	public Differential_Evolution()
   	{
      	 String[] varItems = {"1.DE/rand/1/bin", "2.DE/rand/1/exp", "3.DE/best/1/bin ", "4.DE/best/1/exp", "5.DE/rand/2/bin", "6.DE/rand/2/exp", "7.DE/best/2/bin", "8.DE/best/2/exp", "9.DE/current-to-rand/1/bin", "10.DE/current-to-rand/1/exp", "11.DE/current-to-best/1/bin", "12.DE/current-to-best/1/exp", "13.DE/rand-to-best/1/bin", "14.DE/rand-to-best/1/exp"};
        String[] funcItems = {"1.Sphere Model - f01 ", "2.Schwefel's Problem - f02", "3.Schwefel's problem - f03 ", "4.Schwefel's problem - f04 ", "5.Generalized Rosernbrock's function - f05 ", "6.Step Funcation - f06", "7.Quartic Function with noise - f07", "8.Generalized Schewfel's funcion - f08", "9.Generalized Rastrigin's function - f09 ", "10.Ackley's function - f10", "11.Generalized Griewank's function - f11", "12.Generalized Penalized function - f12", "13.Generalized Penalized function - f13", "14.Bohachersky Function - f14 "};
        
	// creating second panel
	
       	final JFrame frame2 = new JFrame ("Output");
        frame2.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame2.getContentPane().setPreferredSize(new Dimension(762, 604));
        Container c = frame2.getContentPane();
        frame2.pack();
        c.setLayout (null);
	// creating second panel
        
        
        //Creating third panel
        final JFrame frame3 = new JFrame ("Code Running");
        frame3.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame3.getContentPane().setPreferredSize(new Dimension(648, 514));
        Container d = frame3.getContentPane();
        frame3.pack();
        //Creating third panel
        
        JMenu fileMenu = new JMenu ("File");
        JMenuItem printItem = new JMenuItem ("Print");
        fileMenu.add (printItem);
        JMenuItem exitItem = new JMenuItem ("Exit");
        fileMenu.add (exitItem);
        JMenu helpMenu = new JMenu ("Help");
        JMenuItem contentsItem = new JMenuItem ("Contents");
        helpMenu.add (contentsItem);
        JMenuItem aboutItem = new JMenuItem ("About");
        helpMenu.add (aboutItem);

        //construct components
        de = new JRadioButton ("DE");
        de_evo = new JRadioButton ("DE with evolving parameters");
        var = new JComboBox (varItems);
        fun = new JComboBox (funcItems);
        menu = new JMenuBar();
        menu.add (fileMenu);
        menu.add (helpMenu);
        jcomp6 = new JLabel ("DE Variant");
        jcomp7 = new JLabel ("Benchmark Function");
        np_val = new JTextField (0);
        jcomp9 = new JLabel ("NP : ");
        cr_val = new JTextField (5);
        jcomp11 = new JLabel ("CR :");
        d_val = new JTextField (5);
        jcomp13 = new JLabel ("D : ");
        jcomp14 = new JLabel ("Max Gen :");
        gen_val = new JTextField (5);
        mov = new JCheckBox ("MOV");
        avg_g = new JCheckBox ("Average Gen");
        stdevn = new JCheckBox ("Standard Deviation");
        speed = new JCheckBox ("Speed");
        qm = new JCheckBox ("QM");
        graph = new JCheckBox ("graph");
        test = new JCheckBox ("Ttest");
        qt = new JCheckBox ("Quality Test");
        pop_var = new JCheckBox ("Population Variance");
        run = new JButton ("RUN ");

	lab1 = new JLabel ("Mean Objective Function value :");
        lab2 = new JLabel ("Avg. No. Of Generations :");
        lab3 = new JLabel ("nFE (no. of function evaluations) : ");
        lab4 = new JLabel ("Standard Deviation : ");
        lab5 = new JLabel ("Population Varaince:");
        t1 = new JLabel ("");
        t2 = new JLabel ("");
        t3 = new JLabel ("");
        t4 = new JLabel ("");
        t5 = new JLabel ("");;
        graph1 = new JButton ("GEN v/s MOV graph");
        graph2 = new JButton ("Generations per run graph");
        lab6 = new JLabel ("Success Rate (in % ) :");
        t6 = new JLabel ("");
        lab7 = new JLabel ("Time Consumed :");
        t7 = new JLabel ("");
        labforgraph = new JLabel ("");

	p1 = new JLabel ("DE Variant Selected : ");
        p11 = new JLabel ("");
        p2 = new JLabel ("Benchmark Function Selected :");
        p22 = new JLabel ("");
        p3 = new JLabel ("Run Completed : ");
        per = new JLabel ("Percentage Completed: ");
        per_v = new JLabel ("p");
        p33 = new JLabel ("");
        head = new JLabel ("DE is Running...");


        //adjust size and set layout
        
        
        setPreferredSize (new Dimension (767, 594));
        setLayout (null);
	

        //add components
        add (de);
        add (de_evo);
        add (var);
        add (fun);
        add (menu);
        add (jcomp6);
        add (jcomp7);
        add (np_val);
        add (jcomp9);
        add (cr_val);
        add (jcomp11);
        add (d_val);
        add (jcomp13);
        add (jcomp14);
        add (gen_val);
        add (mov);
        add (avg_g);
        add (stdevn);
        add (speed);
        add (qm);
        add (graph);
        add (test);
        add (qt);
        add (pop_var);
        add (run);

	c.add (lab1);
        c.add (lab2);
        c.add (lab3);
        c.add (lab4);
        c.add (lab5);
        c.add (t1);
        c.add (t2);
        c.add (t3);
        c.add (t4);
        c.add (t5);
        c.add (graph1);
        c.add (graph2);
        c.add (lab6);
        c.add (t6);
        c.add (lab7);
        c.add (t7);
        c.add (labforgraph);
        
        d.add (p1);
        d.add (p11);
        d.add (p2);
        d.add (p22);
        d.add (p3);
        d.add (per);
        d.add (per_v);
      //  d.add (p33);
        d.add (head);
        
        //set component bounds (only needed by Absolute Positioning)
        de.setBounds (25, 30, 105, 20);
        de_evo.setBounds (245, 30, 240, 20);
        var.setBounds (10, 135, 290, 30);
        fun.setBounds (455, 135, 290, 30);
        menu.setBounds (0, 0, 775, 25);
        jcomp6.setBounds (10, 100, 100, 25);
        jcomp7.setBounds (455, 100, 210, 25);
        np_val.setBounds (65, 200, 45, 25);
        jcomp9.setBounds (30, 200, 35, 25);
        cr_val.setBounds (195, 200, 50, 25);
        jcomp11.setBounds (160, 200, 35, 25);
        d_val.setBounds (330, 200, 50, 25);
        jcomp13.setBounds (300, 200, 30, 25);
        jcomp14.setBounds (450, 200, 75, 25);
        gen_val.setBounds (520, 200, 100, 25);
        mov.setBounds (15, 345, 70, 25);
        avg_g.setBounds (145, 345, 140, 25);
        stdevn.setBounds (335, 345, 190, 25);
        speed.setBounds (530, 345, 100, 25);
        qm.setBounds (15, 410, 100, 25);
        graph.setBounds (145, 410, 100, 25);
        test.setBounds (340, 410, 100, 25);
        qt.setBounds (530, 410, 150, 25);
        pop_var.setBounds (15, 470, 170, 30);
        run.setBounds (45, 535, 660, 40);
        
        lab1.setBounds (5, 50, 290, 35);
        lab2.setBounds (5, 115, 220, 20);
        lab3.setBounds (5, 165, 265, 40);
        lab4.setBounds (5, 230, 235, 30);
        lab5.setBounds (5, 285, 230, 35);
        t1.setBounds (265, 55, 185, 30);
        t2.setBounds (265, 110, 185, 35);
        t3.setBounds (265, 170, 185, 30);
        t4.setBounds (265, 230, 185, 30);
        t5.setBounds (265, 285, 185, 30);
        graph1.setBounds (490, 45, 220, 25);
        graph2.setBounds (490, 100, 220, 25);
        lab6.setBounds (5, 345, 170, 25);
        t6.setBounds (265, 340, 185, 30);
        lab7.setBounds (5, 390, 185, 30);
        t7.setBounds (265, 390, 185, 30);
        labforgraph.setBounds (465, 0, 300, 605);
        
        p1.setBounds (35, 120, 200, 25);
        p11.setBounds (280, 115, 345, 25);
        p2.setBounds (35, 170, 250, 30);
        p22.setBounds (280, 170, 365, 30);
        p3.setBounds (255, 290, 140, 30);
        per.setBounds (250, 330, 185, 30);
        per_v.setBounds (450, 330, 100, 25);
        p33.setBounds (425, 290, 100, 25);
        head.setBounds (175, 25, 300, 30);
        
        
        	//frame1.setVisible (true);
        
        run.addActionListener(new ActionListener() 
      		{
         		public void actionPerformed(ActionEvent e) 
         		{
         			frame.setVisible(false);
         			//frame3.setVisible(true);
         			//p11.setText(" "+var.getSelectedItem().toString());
				//p22.setText(" "+fun.getSelectedItem().toString());
         			
         			de();
         			frame2.setVisible (true);
         		}
      		});
      		de.addActionListener(new ActionListener() 
      		{
         		public void actionPerformed(ActionEvent e) 
         		{
            			click1 = click1 + 1;
            			if(click1 % 2 == 1)
            			{
            				de_evo.setEnabled(false);
            			}
            			else
            			de_evo.setEnabled(true);
         		}
      		});
      		de_evo.addActionListener(new ActionListener() 
      		{
         		public void actionPerformed(ActionEvent e) 
         		{
            				click2 = click2 + 1;
            				if(click2 % 2 == 1)
            				{
            				de.setEnabled(false);
            				np_val.setEnabled(false);
            				cr_val.setEnabled(false);
            				d_val.setEnabled(false);
            				gen_val.setEnabled(false);
            				np_val.setText("60");
            				cr_val.setText("0.9");
            				d_val.setText("30");
            				gen_val.setText("3000");
            				}
            				else
            				{
            				de.setEnabled(true);
            				np_val.setEnabled(true);
            				cr_val.setEnabled(true);
            				d_val.setEnabled(true);
            				gen_val.setEnabled(true);
            					
            				}
         		}
      		});
      		graph1.addActionListener(new ActionListener() 
      		{
         		public void actionPerformed(ActionEvent e) 
         		{
            				XYLineChartExample.main(arg);
         		}
      		});
        	
        	graph2.addActionListener(new ActionListener() 
      		{
         		public void actionPerformed(ActionEvent e) 
         		{
            				run_vs_gen.main(arg);
         		}
      		});
        
        
   	}
   	public static void main(String[] args)
   	{
      		pass(args);;
        	frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        	frame.getContentPane().add (new Differential_Evolution());
        	frame.pack();
        	frame.setVisible (true);
		//System.out.println(totalTime);
   	}
   	public void de()
   	{
   		n1 = np_val.getText();
      		n2 = cr_val.getText();
      		n3 = d_val.getText();
      		n4 = gen_val.getText();
   		
   		
                
		try{
		PrintWriter writer1 = new PrintWriter("single_run.xls", "UTF-8");
		PrintWriter writer2 = new PrintWriter("Final.xls", "UTF-8");
		PrintWriter writer3 = new PrintWriter("comparison_normal_de(100 runs).xls","UTF-8");
		PrintWriter writer4 = new PrintWriter("G_vs_MOV.txt");
		PrintWriter writer5 = new PrintWriter("run_vs_gen.txt");
		PrintWriter writer6 = new PrintWriter("population.txt");
		writer1.printf("Run\tG\tObj_fn_val\tMean\tStd Dev\tF\tVariance\n");
		writer2.printf("Run\tG\tObj_fn_val\tMean\tStd Dev\n");
		writer3.printf("Normal Differential Evolution for 100 runs\n\n");
		writer3.printf("Function\tAverage No of G\tMean Objective val\n");
		int func=1,de_var=1;
		String value1=var.getSelectedItem().toString();
		String value2=fun.getSelectedItem().toString();
		System.out.println("Calculating ...")
		
		
		switch(value1)
		{
			case "1.DE/rand/1/bin": de_var = 1;
							break;
			case "2.DE/rand/1/exp" : de_var = 2;
							break;
			case "3.DE/best/1/bin ": de_var = 3;
							break;
			case "4.DE/best/1/exp": de_var = 4;
							break;
			case "5.DE/rand/2/bin": de_var = 5;
							break;
			case "6.DE/rand/2/exp": de_var = 6;
							break;
			case "7.DE/best/2/bin": de_var = 7;
							break;
			case "8.DE/best/2/exp": de_var = 8;
							break;
			case "9.DE/current-to-rand/1/bin": de_var = 9;
							break;
			case "10.DE/current-to-rand/1/exp": de_var = 10;
							break;
			case "11.DE/current-to-best/1/bin": de_var = 11;
							break;
			case "12.DE/current-to-best/1/exp": de_var = 12;
							break;
			case "13.DE/rand-to-best/1/bin": de_var = 13;
							break;
			case "14.DE/rand-to-best/1/exp": de_var = 14;
							break;
		}
		
		switch(value2)
		{
			case "1.Sphere Model - f01 ": func = 1;
							break;
			case "2.Schwefel's Problem - f02": func = 2;
							break;
			case "3.Schwefel's problem - f03 ": func = 3;
							break;
			case "4.Schwefel's problem - f04 ": func = 4;
							break;
			case "5.Generalized Rosernbrock's function - f05 ": func = 5;
							break;
			case "6.Step Funcation - f06": func = 6;
							break;
			case "7.Quartic Function with noise - f07": func = 7;
							break;
			case "8.Generalized Schewfel's funcion - f08": func = 8;
							break;
			case "9.Generalized Rastrigin's function - f09 ": func = 9;
							break;
			case "10.Ackley's function - f10": func = 10;
							break;
			case "11.Generalized Griewank's function - f11": func = 11;
							break;
			case "12.Generalized Penalized function - f12": func = 12;
							break;
			case "13.Generalized Penalized function - f13": func = 13;
							break;
			case "14.Bohachersky Function - f14 ": func = 14;
							break;
		}
               	int NP,D;
		double F,CR;
		int i,j,k,l,temp,r1,r2,r3,flag=0,yes=0;
		int count,G,gen_max,index=0;
		double low=0,up=0;
		double mov=0,nFE=0,avg_G=0;
		double minval=0,sum=0,mean=0,xdiff, xdiffsum,stddev=0;
		count=1;
		gen_max = Integer.parseInt(n4);
		NP = Integer.parseInt(n1);
		D  = Integer.parseInt(n3);
		F = 0.5;
		switch(func)
		{
			case 1:
				low=-100;up=100;
			break;
			
			case 2:
				low=-10;up=10;
			break;
		
			case 3:
				low=-100;up=100;
			break;
		
			case 4:
                		low=-100;up=100;
                	break;
		
			case 5:
                		low=-30;up=30;
                	break;
			
			case 6:
                		low=-100;up=100;
                	break;
			case 7:
                		low=-1.28;up=1.28;
                	break;
	
			case 8:
                		low=-500;up=500;
                	break;
		
			case 9:
                		low=-5.12;up=5.12;
                	break;
		
			case 10:
                		low=-32;up=32;
               	 	break;
	
			case 11:
                		low=-600;up=600;
                	break;
	
			case 12:
                		low=-50;up=50;
                	break;
	
			case 13:
                		low=-50;up=50;
               		break;
	
			case 14:
				low=-10;up=10;
			break;
		}
		CR = Double.parseDouble(n2);
		double[][] pop = new double[NP][D+1];
		double[][] next   = new double[NP][D+1];
		double[] trial    = new double[D+1];
		Random rand = new Random();
		int rannum;
		t1.setText(" "+mov);
		int tot_run = 10;
		while(count<=tot_run)
		{
			/* Initializing the population */
			for(i=0;i<NP;i++)
			{
				for(j=0;j<D;j++)
				{
					pop[i][j] = low+(up-low)*rnd_uni();
					writer6.printf("%d,%.4f\n",1,pop[i][j]); 
				}
			pop[i][D] = bench_func(D,pop[i],func);
			}
			
			/* Repeating the process for gen_max times */
			outerloop:
			for(G=1;G<gen_max;G++)
			{
				
				for(i=0;i<NP;i++)
				{
					/* Randomly selecting three population vectors */
					do{r1=(int)(NP*rnd_uni());}while(r1==i);
					do{r2=(int)(NP*rnd_uni());}while(r2==i||r2==r1);
					do{r3=(int)(NP*rnd_uni());}while(r3==i||r3==r1||r3==r2);
					j = (int)rnd_uni() * D;
					
					/* Mutation and crossover */
					for(k=0;k<D;k++)
					{
						if(rnd_uni()<CR || k==D)
						{
							trial[j] = pop[r3][j] + F * (pop[r1][j]-pop[r2][j]);
						}
						else
						{
							trial[j] = pop[i][j];
						}
						j = (j+1) % D;
					}
					trial[D] = bench_func(D,trial,func);
					
					/* Comparing the new vector with target and choosing the best as next */
					if(trial[D]<=pop[i][D])
					{
						for(j=0;j<D;j++)
						{
							next[i][j] = trial[j];
						}
						next[i][D] = trial[D];
					}
					else
					{
						for(j=0;j<D;j++)
						{
							next[i][j] = pop[i][j];
						}
						next[i][D] = pop[i][D];
					}
					
					/* Stopping Condition */
					if(Math.abs(trial[D])<1e-12)
		                        {
	                		        flag=1;
	                		        yes = yes+1;
					} 	
				}/*loop ends NP times */
				
				/* Copying next to pop */
				for(i=0;i<NP;i++)
				{
					for(j=0;j<=D;j++)
					{
						pop[i][j] = next[i][j];
					}
				}
				/* Finding the best objective function, mean and standard deviation */
				minval = Math.abs(pop[0][D]);
				sum=0;
				mean=0;
				for(i =0;i<NP;i++)
				{
					if(Math.abs(pop[i][D])<=minval)
					{
						minval = Math.abs(pop[i][D]);
						index=i;
					}
					
						sum = sum +pop[i][D];
				}
				mean = sum/NP;
				xdiffsum=0;
				for(i=0;i<NP;i++)
				{
					xdiff=Math.pow((pop[i][D]-mean),2);
					xdiffsum+=xdiff;
				}
				stddev=Math.sqrt(xdiffsum/(NP-1));
				if(flag==1)
			       	{
			         	flag=0;
			         	
	        		   	break outerloop;	// If stopping condition occurs, exit.
			      	}

			      	if(count==1)
			      	{
				writer1.printf("%d\t%d\t%.4f\t%.5f\t%.5f\t%.3f\t%.5f\n",count,G,pop[index][D],mean,stddev,F,(stddev*stddev));
					
				 	writer4.printf("%d,%.4f\n",G,pop[index][D]);
			      	}
			      	if(count==1)
			      	{
			      	for(i=0;i<NP;i++)
			      	{
			      		for(j=0;j<D;j++)
			      		{
			      			writer6.printf("%d,%.4f\n",G,pop[i][j]);
			      		}
			      	}
			      	}
			      	writer6.close();
			}
			
			writer2.printf("%d\t%d\t%.4f\t%.5f\t%.5f\n",count,G,pop[index][D],mean,stddev);
			avg_G = avg_G + G;
			mov = mov + pop[index][D];
			//System.out.printf("\n Objective value : %.4f at run = %d ",pop[index][D],count);
			
			System.out.printf("\nDE RUNNING ...  COMPLETED %.0f percent",(double) count/tot_run * 100);
			
		writer5.printf("%d,%d\n",count,G);
		//p33.setText(" "+count);
		count++;
		}
               
		nFE = avg_G * NP;
		nFE = nFE/tot_run;
		mov = mov/tot_run;
		avg_G = Math.floor(avg_G / tot_run);
		writer2.printf("\n \nNo. G to Solution \t %.4f",avg_G);
		writer2.printf("\n nFE \t %d",(int)nFE);
		writer2.printf("\n Avg MOV \t%.4f",mov);
		writer2.printf("\n Success rate \t%.4f percent",(double)((yes/tot_run)*100));
		writer3.printf("%d\t%.4f\t%.4f\n",func,avg_G,mov);
		writer1.close();
		writer2.close();
		
		t1.setText(" "+mov);
		t2.setText(""+avg_G);
		t3.setText(" "+(int)nFE);
		t4.setText(" "+stddev);	
		writer3.close();
		writer4.close();
		writer5.close();
		}catch(IOException e){
				e.printStackTrace();
				}	

    }
    public static double bench_func(int Dim, double[] X,int choice)
	{
		int i,j;
		double sum,a=0,b=0,aa,bb,sum1,sum2,temp=0.0,max;
		double c=0,y0,y29,y,yy;
		double pi=Math.acos(-1.0);
		double e=Math.exp(1.0);
		
		sum=0.0;sum1=0.0;sum2=1.0;
		switch(choice)
		{
			case 1 :/*shere model - f01 */
			for(i=0;i<Dim;i++)
			{
				sum+=X[i]*X[i];
			}
			break;
			
			case 2 :/*schewefel's problem - f02 */
			for(i=0;i<Dim;i++)
			{
				sum1+=Math.abs(X[i]);
			}
			for(i=0;i<Dim;i++)
			{
				sum2*=Math.abs(X[i]);
			}
			sum=sum1+sum2;
			break;
			
			case 3 :/*Schewefel's problem - f03 */
			for(i=0;i<Dim;i++)
			{
		  		sum1=0;
		  		for(j=0;j<i;j++)
				{
					sum1+=X[j];
				}
		
				sum+=sum1*sum1;
			}
			break;
		 	
		 	case 4 :/*Schewefel's problem - f04 */
			max=Math.abs(X[0]);
                	for(i=1;i<Dim;i++)
                	{
				if(Math.abs(X[i])>max)
				{
					max=Math.abs(X[i]);
				}
	        	}
		 	sum=max;
                	break;
	 		
	 		case 5 :/*Generalized Rosenbrock's function - f05 */
                	for(i=0;i<Dim-1;i++)
                	{
				a=X[i+1]-Math.pow(X[i],2);
				aa=Math.pow(a,2);
				b=Math.pow((X[i]-1),2);
				sum+=Math.abs(100*aa+b);
		
                	}
                	break;
	 
	 		case 6 :/*Step Funcation - f06 */
                	for(i=0;i<Dim;i++)
               	 	{
                		sum+=Math.pow(Math.floor(X[i]+0.5),2);
                	}
                	break;
                	
	 		case 7 :/*Quartic Function with Noise  - f07 */
                	for(i=0;i<Dim;i++)
                	{
                		sum+=i*Math.pow(X[i],4.0);
                	}
			sum+=rnd_uni();
                	break;
	 	
	 	case 8 :/*Generalized Schewefel's problem - f08 */
                for(i=0;i<Dim;i++)
                {
			sum+=X[i]*Math.sin(Math.sqrt(Math.abs(X[i])));
		}
		sum+=12569.5;
                break;
	 
	 	case 9 :/*Generalized Rastrigin's Funcation  - f09 */
                for(i=0;i<Dim;i++)
               	{
                	sum=sum+(Math.pow(X[i],2)-10*Math.cos(2*pi*X[i])+10);
                }
                break;
	 
	 	case 10 :/*Ackley's function  - f10 */
                for(i=0;i<Dim;i++)
                {
        		sum1=sum1+Math.pow(X[i],2);
			sum2=sum2+Math.cos(2*pi*X[i]); 
                }
		sum=-20*Math.exp(-0.2*Math.sqrt(sum1/Dim))-Math.exp(sum2/Dim)+20+e;
                break;
	 
	 	case 11 :/*Generalized Rastrigin;s Function  - f11 */
                for(i=1;i<=Dim;i++)
                {
                	sum1+=Math.pow(X[i-1],2);
			sum2=sum2*Math.cos(X[i-1]/Math.sqrt((double)i));
		}
		sum=(sum1/4000)-sum2+1;
        	
                break;
	 
	 	case 12 :/*Generalized Penalized Function - f12 */
		for(i=0;i<Dim;i++)
		{
			c+=u(X[i],10);
		}
		y0=1+(X[0]+1)/4;
		y29=1+(X[Dim-1]+1)/4;
		a=10*Math.pow(Math.sin(pi*y0),2);
		for(i=0;i<Dim-1;i++)
		{
			y=1+(X[i]+1)/4;
			yy=1+(X[i+1]+1)/4;
			b=b+Math.pow((y-1),2)*(1+10*Math.pow(Math.sin(pi*yy),2));
		}
		bb=Math.pow((y29-1),2);		
		sum=(pi*(a+b+bb)/Dim)+c;
		break;
	 	
	 	case 13 :/*Generalized Penalized Function -f13 */
                for(i=0;i<Dim;i++)
                {
               		a=a+Math.pow((X[i]-1),2)*(1+Math.pow(Math.sin(3*pi*X[i+1]),2)); 
                }
		b=Math.pow(Math.sin(3*pi*X[0]),2);
		bb=Math.pow((X[Dim-1]-1),2)*(1+Math.pow(Math.sin(2*pi*X[Dim-1]),2));
		for(i=0;i<Dim;i++)
		{
			c+=u(X[i],5);
		}
		sum=0.1*(b+a+bb)+c;
               	break;
	
		case 14:
		for(i=0;i<Dim-1;i++)
		{
		        sum+=Math.pow(X[i],2)+2*Math.pow(X[i+1],2)-0.3*Math.cos(3*pi*X[i])-0.4*Math.cos(4*pi*X[i+1])+0.7;
		}
		break;

		}
		return(sum);
	}
	
	public static double u(double xi,int ai)
	{
		int ki=100,mi=4;
		double ans=0.0;
		if(xi>ai)
		{
			ans=ki*Math.pow((xi-ai),mi);
		}
		else if((xi>=-ai)&&(xi<=ai))
		{
			ans=0;
		}
		else if(xi<-ai)
		{
			ans=ki*Math.pow((-xi-ai),mi);
		}
		return(ans);
	}
	
	public static double rnd_uni()
	{
		int i =0;
		double x;
		do
		{
			i++;
			x = Math.random();
		}while(i<5);
		return x;
	}
   	
}
