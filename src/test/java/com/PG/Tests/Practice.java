package com.PG.Tests;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Practice {

	public static void main(String[] args) throws InterruptedException 
	{
		// TODO Auto-generated method stub
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
//		driver.get("http://192.168.10.75/elmsproduct_testI/");
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//a[contains(text(),'Log In')]")).click();
//		driver.findElement(By.xpath("//a[contains(text(),'Investor')]")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.id("txtUserName")).sendKeys("LMS2100226");
//		driver.findElement(By.id("txtPassword")).sendKeys("Admin@123");
//		Thread.sleep(20000);
//		driver.findElement(By.id("btnLogin")).click();
//		driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[2]/a/span")).click();
//		driver.findElement(By.xpath("//h4[.='Land Registration']/..//a[contains(text(),'View ')]")).click();
		        BufferedImage img=null;
		        File f=null;
		        
		        long startTime = System.currentTimeMillis();
		        try{
		            f=new File("C:\\Users\\subrat.sharma\\Desktop\\Screenshot (2).jpg");
		            img=ImageIO.read(f);
		        }
			catch(IOException e)
		        {
		            System.out.println(e);
		        }
		        
		        int width=img.getWidth();
		        int height=img.getHeight();
		        
		        for(int y=1;y<height-1;y++)
		            for(int x=1;x<width-1;x++)
		            {
		                int ar[]=new int[9];
		                ar[0]=img.getRGB(x, y);
		                ar[1]=img.getRGB(x-1, y-1);
		                ar[2]=img.getRGB(x-1, y);
		                ar[3]=img.getRGB(x-1, y+1);
		                ar[4]=img.getRGB(x, y-1);
		                ar[5]=img.getRGB(x, y+1);
		                ar[6]=img.getRGB(x+1, y-1);
		                ar[7]=img.getRGB(x+1, y);
		                ar[8]=img.getRGB(x+1, y+1);
		                
				int i, j;
			        for (i = 0; i < 8; i++)       
				for (j = 0; j < 8-i; j++)  
		        	if (ar[j] > ar[j+1]) 
		              	{
					int temp=ar[j];
					ar[j]=ar[j+1];
					ar[j+1]=temp;
				}

		                //Arrays.sort(ar);
		                int p=img.getRGB(x, y);
		                int p1=ar[4];
		                
		                if(p>255||p<0)
		                    img.setRGB(x, y, p1);
		            }
		        
		        try
			{
			      ImageIO.write(img, "bmp", new File("C:\\Users\\subrat.sharma\\Desktop\\cleaned1.jpg"));
		        }
			catch(IOException e)
		        {
		            System.out.println(e);
		        }
		        long endTime = System.currentTimeMillis();
		        System.out.println(Math.abs(startTime-endTime)+" milliseconds");
	}

}
