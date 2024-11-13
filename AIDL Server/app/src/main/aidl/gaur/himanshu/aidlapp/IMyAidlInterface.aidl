// IMyAidlInterface.aidl
package gaur.himanshu.aidlapp;

// Declare any non-default types here with import statements

parcelable Dummy;

interface IMyAidlInterface {

    int calculate(int a , int b);

    String getMessage();

    Dummy transformation(in Dummy dummy);

}