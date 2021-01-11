import org.junit.Test;

import static org.junit.Assert.*;
public class MyVectorTest {
    //객체와 크기 선언
    MyVectorTest[] objArr = {
            new MyVectorTest(1),
            new MyVectorTest(2),
            new MyVectorTest(10),
            new MyVectorTest(210),
            new MyVectorTest(100000)
    };
    int size = objArr.length;

    //생성자 선언 및 초기화
    public MyVectorTest() {
        this(10);
    }
    MyVectorTest(int capacity){
        for(int i=0; i< objArr.length; i++) {
            objArr[i].setCapacity(capacity);
        }
    }

    // 객체배열에 저장된 객체 갯수
    public int size(){
        int answer = 0;
        for(int i=0; i<objArr.length; i++) {
            answer = objArr[i].size();
        }
        return answer;
    }

    // 객체배열 길이
    int Capacity(){
        return objArr.length;
    }

    // 무엇이 문제인지 생각할 시간이 필요하다.
    // objArr[i].IsEmpty()가 바로 return값으로 안된다는건 boolean으로 반환을 못한다는 뜻인 것 같다.
    boolean IsEmpty(){
        boolean answer = false;
        for(int i=0; i<objArr.length; i++){
            return objArr[i].IsEmpty();
        }
        return answer;
    }

    // 객체 배열의 모든 요소를 null
    void clear(){
        for(int i=0; i<objArr.length; i++) {
            objArr[i].clear();
        }
    }

    Object get(int index){
        Object answer = "";
        for(int i=0; i<objArr.length; i++) {
            answer = objArr[i].get(index);
        }
        return answer;
    }

    int indexOf(int obj){
        int answer = 0;
        for(int i=0; i<objArr.length; i++) {
            answer = objArr[i].indexOf(obj);
        }
        return answer;
    }

    void setCapacity(int capacity){
        for(int i=0; i<objArr.length; i++) {
            objArr[i].setCapacity(capacity);
        }
    }

    void ensureCapacity(int minCapacity){
        for(int i=0; i<objArr.length; i++) {
            objArr[i].ensureCapacity(minCapacity);
        }
    }

    Object remove(int index){
        Object answer = "";
        for(int i=0; i<objArr.length; i++) {
           return objArr[i].remove(index);
        }
        return answer;
    }
}