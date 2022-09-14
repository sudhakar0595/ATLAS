
public class SubSet {

	public static void main(String[] args) {
		int n = 5;
		int [] arr = {4,34,12,5,2};
		int sum = 11;
		System.out.println(find(n,arr,sum));
		
	}
	
	public static int find(int n,int[] arr, int sum) {
		//int [] sub;
		for (int i = 0; i< n; i++) {
			int temp = arr[i];
			
			for (int j = 1; j< n; j++) {
				temp = temp + arr[j];
				if(temp>sum) {
					temp = temp - arr[j];
				}
				else if(temp == sum) {
					//System.out.println(arr[i] +","+arr[j]);
					return 1;
				}
			}
		}
		return 0;
	}

}
