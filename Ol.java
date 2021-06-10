package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ol {
public static final String PATH="/home/galimimus/Загрузки/26.txt";
	public static void main(String[] args) throws NumberFormatException, IOException{
		// TODO Auto-generated method stub
		File file = new File(PATH);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		int[] goods = new int[1000];
		int i = 0;
		String nm = reader.readLine();
		int n = 0, s =0, m=10000;
		//System.out.println(nm);
		while (i<1000) {
		goods[i]=Integer.parseInt(reader.readLine());
		if((goods[i]<=210)&&(goods[i]>=200)) {
			n++;
			s+=goods[i];
			goods[i]=0;
			//System.out.println(n+" "+s);
		}
		i++;
	}
		//m=m-s;
		Bitch b = new Bitch();
		int[] goods1 = b.bubbleSort(goods);
		int[] result = b.count(goods1, n, s);
		System.out.println(result[0]+" "+result[1]);
	}
}
class Bitch{
	int[] bubbleSort(int[] arr) {
		for(int i = arr.length-1 ; i > 0 ; i--){
	        for(int j = 0 ; j < i ; j++){ if( arr[j] > arr[j+1] ){
                int tmp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = tmp;
            }
        }
    }
		//int n=0;
		//while (n<1000) {
			//System.out.println(arr[n]);
			//n++;
		//}
		return arr;
	}
	int[] count(int[] goods, int countg, int s) {
		
		int n = 13;
		//System.out.print(goods[12]);
		while(s+goods[n]<=10000) {
			s+=goods[n];
			countg++;
			n++;
		}
		int a = n, i=1;
		
		while(n>=13) {
		while(goods[a]+s-goods[a-i]<=10000) {
			s=s-goods[n-i]+goods[n];
		}
		n--;
		i++;
		}
		
		int[] result = new int[]{countg, s};
		return result;
		
	}
}