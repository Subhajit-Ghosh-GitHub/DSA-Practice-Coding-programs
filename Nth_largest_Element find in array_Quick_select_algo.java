package day2;
import java.util.*;
public class Nth_largest_Quick_select_algo {
	public static void  swap(int arr[],int i,int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
		
	}
	public static int   partition (int arr[],int L,int R) {
		int piv=arr[L];
		
		int i=L;
		int j=R;
		while(i<=j) {
			if(arr[i]<piv && arr[j]>piv && i<=j) {
				swap(arr,i,j);
				i++;
				j--;
			} if(arr[i]>=piv){
				i++;
			} if(arr[j]< piv){
				j--;
			}
		}
			swap(arr,L,j);
		
		return j;
	}
		
		
	public static void QuickSelect(int arr[],int i,int j,int k) {
		int piv=partition(arr,i,j);
		while(true) {
			if(piv==k) {
				System.out.println(k+1+"th largets element is "+arr[k]);
				break;
			}else if(piv>k){
				j=piv-1;
			}else {
				i=piv+1;
			}
			piv=partition(arr,i,j);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner (System.in);
		System.out.println("Enter no of elements in array\n");
		int n=sc.nextInt();
		System.out.println("Enter element's in array\n");
		int arr[]=new int [n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		int p;
		System.out.println("Enter nth largest element\n");
		p=sc.nextInt();
		//System.out.println(Arrays.toString(arr)+ k);
		if(p >arr.length || p<=0) {
			System.out.println("k th position is invalid ");
		}else {
			QuickSelect(arr,0,n-1,p-1);
		}
	}
}
