Public class kClosest_QuickSelect {
	

	void setDistanceFromP(Point[] points, Point p) {
		for(int i = 0; i < points.length; ++i) {
			points[i].distance = (points[i].x - p.x) * (points[i].x - p.x)+ 
					(points[i].y - p.y) * (points[i].y - p.y);
		}
	}

	public int partition(Point[] points, int l, int r, int m) {
		int pivot = points[m].distance;
		swap(points[m], points[r]);
		m = r;
		r--;
		while(l < r) {
			if(points[l].distance >= pivot) {
				swap(points[l], points[r--]);
			}
			else l++;
		}
		swap(points[l], points[m]);
		m = l;
		return l;
	}

	public void swap(int a, int b) {
		int tmp = a;
		a = b;
		b = tmp;
	}

	public Point quickSelect(Point[] points, int l, int r, int k) {
		int m = (l + r) / 2;
		m = partition(points, l, r, m);	//TODO
		if(m == k)	
			return points[m];
		if(m < k) 
			return quickSelect(points, m+1, r, k - m)
		else
			
	}
	class Point {
		public int x;
		public int y;
		public int distance;
	}
}
	