class Sort {
	public static void main(String[] args) {
		int[] a = {2, 4, 3, 1, 9, 7, 8, 6, 5};
		int i = 0;
		while (i < 8) {
			if  (a[i] < a[i +1]) {
        	                int s = a[i];
        	                a[i] = a[i + 1];
        	                a[i + 1] = s;
        	                i = 0;
        	        }
        	        else {
        	                i =i + 1;
        	        }

		}
		for (i = 0; i<9; i++) {
		System.out.print( a[i] + ", ");
		}
	}
}
