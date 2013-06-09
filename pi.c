#include<stdio.h>
#include<math.h>

double madhav_leibniz(int steps);
double euler_leibniz(int steps);
double euler_zeta(int steps);



double euler_zeta(steps) {
	int k = 1  ;
	double sum = 0.0 ;
	while(k < steps) {
		sum += 1.0 / (k*k);
		k++;
	}

	/* pi^2/6 = series sum */
	double pi = sqrt(6.0*sum);
	printf("pi = %f euler zeta(2) for N = %d \n",pi,steps);
}

double euler_leibniz(steps) {
	int k = 0  ;
	double sum = 0.0 ;
	
	while(k < steps ) {
		sum+= 2.0 /((4*k+1)*(4*k+3)) ; 
		k++;
	}

	printf("pi = %f leibniz euler series for N = %d \n",sum*4.0,steps);


}


double madhav_leibniz(steps) {
	int k = 0  ;
	double sum = 0.0 ;
	
	while(k < steps ) {
		sum+= (pow(-1.0,k))/(2*k+1.0);  	
		k++;
	}

	printf("pi = %f madhav leibniz series for N = %d \n",sum*4.0,steps);
}


int main() {
	madhav_leibniz(1000);
	euler_leibniz(1000);
	euler_zeta(1000);

	return 0 ;

}
