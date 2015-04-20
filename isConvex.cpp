#include<iostream.h>
//#define N
const int N=4;
int tt(double p[][2],int a,int b) {
	//a为下标，不能为float
	int temp[N],k = 0;
	double t;
	for(int i = 0; i < N; i++) {
		if(i == a || i == b) continue;
		t=p[i][0]*(p[b][1] - p[a][1]) + (p[a][0] - p[b][0])*p[i][1]-p[a][0]*p[b][1]+p[b][0]*p[a][1];
		if(t == 0) return 0;
		else if(t > 0) temp[k++] = 1;
		else temp[k++]=-1;
	}
	for(int j = 1; j < k; j++) {
		if(temp[0] != temp[j]) return 0;
	}
	return 1;
}
int real(double p[][2]) {
	int flag[N],m = 0;
	for(int i = 0; i < N; i++) flag[i] = 0;
	for( i = 0; i < N; i++) {
		for(int j = 1; j < N; j++) {
			if(flag[j]) continue;
			if(tt(p, m, j)) {
				flag[m] = 1;
				m = j;
				break;
			}
		}
	}
	flag[m] = 1;
	for(i=0; i<N; i++) {
		if(flag[i] == 0) return 0;
	}
	if(tt(p, 0, m)) return 1;
	return 0;
}
void main() {
double p[N][2];
char ch='y';
while (ch=='y'||ch=='Y') {
	cout<<"Please input x & y for the nodes:"<<endl;
	for(int i=0; i<N; i++) {
	cout << "Coordinate" << i << ":";
	cin >> p[i][0] >> p[i][1];
	//cin>>**p>>*(*p+1);
	cout << p[i][0] << "," << p[i][1] << endl;
	}
	if (real(p)) cout << "Yes!";
	else cout << "No!";
	}
}