import org.junit.Test;

import static org.junit.Assert.*;

public class MyVectorTest {

        //객체와 크기 선언 (objArr이 null이였다면 에러가 난다)(가능하면 0으로 만들어주자)
        private Object[] objArr = new Object[0];
        private int size = 0;

        //생성자 선언 및 초기화
        public MyVectorTest() {
            this(10);
        }
        MyVectorTest(int capacity){
            //유효성 검사
            if(capacity<0){
                System.out.println("응 용량 다시 가져와");
                return;
            }
            objArr = new Object[capacity];
        }

        // 객체배열(objArr)에 저장된 객체 갯수
        public int size(){
            return objArr;
        }

        // 객체배열(objArr) 길이(objArr이 null이였다면 에러가 난다)
        int capacity(){
            return objArr.length;
        }

        boolean add(Object obj){
            // 추가사항 : 추가를 마구잡이로 할 수 없다. 추가 할 공간이 있나?
            ensureCapacity(size+1);

            // 추가공간 만들고나면 뒤에 붙여주기
            objArr[size] = obj;
            size++;
            return true;
        }

        boolean isEmpty(){
            //비었다의 조건 size가 0이냐 아니냐
            return size==0;
        }

        //objArr의 모든 요소를 다 삭제함(모든 요소가 null이 된다는 것)
        void clear(){
            for(int i=0; i< objArr.length; i++){
                objArr[i] = null;
            }

            //size값도 0으로 바꿔야함(초기화하기로했잖아)
            size = 0;
        }

        void ensureCapacity(int minCapacity){
            // minCapacity > 현재 capacity(공간이 부족하지않으면??)
            // 아무것도 할 필요 없다. 줄여지지도 않음

            // else 반대는 현재 공간이 적은데, 공간을 더 늘리는거니깐 가능
            if(minCapacity>capacity()){
                //더 큰 배열 만들어서 복사 후 몸 바꾸기
                Object[] newArr = new Object[minCapacity*2];
                System.arraycopy(objArr, 0, newArr, 0, size);
                objArr = newArr;
            }
        }

        // 몇 번째 index에 obj가 저장되어 있나?
        int indexOf(Object obj){
            final int size = size();
            int index = -999;

            for(int i=0; i<size; i++){
                if(obj.equals(objArr[i])){
                    return i;
                }
            }
            return index;
        }

        Object remove(int index){
            // 1. 유효성 검사 (길이를 벗어남)
            if(index<0 || index>size){
                throw new ArrayIndexOutOfBoundsException(""+index);
            }

            // 삭제된 객체를 따로 저장
            Object old = objArr[index];

            //1. 한칸씩 위로 올려서 복사해주기
            System.arraycopy(objArr, index+1, objArr, index, size);
            //2. 마지막 요소를 null로 저장
            objArr[size-1] = null;
            // 3. size 1줄이기
            size--;

            return old;
        }

        public String toString(){
            String temp = "[";
            final int size = size();

            for(int i=0; i<size; i++){
                temp = temp + objArr[i] + ", ";
            }
            temp = temp + "]";
        }

    @Test
    public void size() {
            MyVector test = new MyVector();
            assertTrue(test.size()==0);
    }

    @Test
    public void capacity(){
        MyVector test = new MyVector();
        assertTrue(test.capacity(100));
    }

    @
}