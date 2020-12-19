# include <iostream>
using namespace std;

class CRC{
	private:
		int data[4];
		int quotient[4];
		int remainder[3];
		int data_copy[4];
		int divisor[4];
		int xor_output[3];
	public:
		void input();
		void sender_side();
		void receiver_side();
		void display();
		int XOR(int, int);	
};

int CRC::XOR(int a, int b){
	if(a == b)
		return 0;
	else
		return 1;
}
void CRC::input(){
	cout<<"\nEnter data";
	for(int i=0;i<4;i++)
	{
	cin>>data[i];
	data_copy[i] = data[i];
		}
	cout<<"\nEnter divisor";
	for(int i=0;i<4;i++)
	{
	cin>>divisor[i];
	}
}

void CRC::sender_side(){
	for(int i=0; i<4; i++){
		if(data_copy[0] == divisor[0]){
			quotient[i]=1;
			for(int j=1; j<=3; j++)
				{
				xor_output[j-1] = XOR(data_copy[j], divisor[j]);
				}
			data_copy[0] = xor_output[0];
			data_copy[1] = xor_output[1];
			data_copy[2] = xor_output[3];
			data_copy[3] = 0;		
			}
		else{
			quotient[i]=1;
			for(int j=1; j<=3; j++)
				{
				xor_output[j-1] = XOR(data_copy[j], divisor[j]);
				}
			data_copy[0] = xor_output[0];
			data_copy[1] = xor_output[1];
			data_copy[2] = xor_output[3];
			data_copy[3] = 0;		
			}
		}	
		remainder[0] = data_copy[0];
		remainder[1] = data_copy[1];
		remainder[2] = data_copy[2];
	}
void CRC::display(){
	cout<<"\nData is\n";
	for(int i=0;i<4;i++)
	{
	cout<<data[i];
	}
	cout<<"\nDivisor is\n";
	for(int i=0;i<4;i++)
	{
	cout<<divisor[i];
	}
	cout<<"\nQuotient is\n";
	for(int i=0;i<4;i++)
	{
	cout<<quotient[i];
	}
	cout<<"\nRemainder is\n";
	for(int i=0;i<3;i++)
	{
	cout<<remainder[i];
	}
}

int main(){
	CRC crc ;
	crc.input();
	crc.sender_side();
	crc.display();
	return 0;
}
