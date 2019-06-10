#include<bits/stdc++.h>
using namespace std;

int main(){
    int i,n,a,a2,d,b2;
    bool s;
    vector<int> b,h;
    cin >> n;
    a=0;
    for(i=1;i<=n;i++){
        s=true;
        cin>>d;
        if(d>a){
            a=d;
        }
        if(!h.empty()){
            if(d<=h.back()){
                s=false;
                if(d<h.back()){
                    while(!h.empty()){
                        if(h.back()<=d){
                            break;
                        }
                        b2=b.back();
                        a2=h.back()*(i-b2);
                        if(a2>a){
                            a=a2;
                        }
                        h.pop_back();
                        b.pop_back();
                    }
                b.push_back(b2);
                h.push_back(d);
                }
            }
        }
        if(s){
            if(d>0){
                b.push_back(i);
                h.push_back(d);
            }
        }
    }
    while(!h.empty()){
        a2=h.back()*(i-b.back());
        if(a2>a){
            a=a2;
        }
        h.pop_back();
        b.pop_back();
    }
    cout<<a<<endl;
    return 0;
}
