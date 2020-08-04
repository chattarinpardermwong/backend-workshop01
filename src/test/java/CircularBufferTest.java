import org.junit.Test;

import static org.junit.Assert.*;

public class CircularBufferTest {
    CircularBuffer cb = new CircularBuffer();

    @Test
    public void create_new_buffer_with_size(){
        cb = new CircularBuffer(5);

    }

    @Test
    public void create_new_buffer_should_empty(){
//        CircularBuffer cb = new CircularBuffer();
        boolean result = cb.isEmpty();//check isEmpty
        assertTrue("Buffer is not empty",result);//return should be True
    }

    @Test
    public void create_new_buffer_with_default_size_should_10(){
//        CircularBuffer cb = new CircularBuffer();
        for(int i=0;i<10;i++){
            cb.writeData("A"+i);//add
        }
        boolean result = cb.isFull();
        assertTrue("Buffer is not full",result);
    }

    @Test
    public void write_A_B_to_buffer_should_read_A_B_from_buffer(){
//        CircularBuffer cb = new CircularBuffer();
        cb.writeData("A");
        cb.writeData("B");
//        String result = cb.readData();
        assertEquals("A",cb.readData());
        assertEquals("B",cb.readData());
    }

    @Test
    public void writeBuffer_should_not_more_than_Buffer(){
//        CircularBuffer cb = new CircularBuffer();
        for(int i=0;i< cb.getBufferSize();i++){
            cb.writeData("A"+i);//add
        }
        for(int i=0;i< cb.getWritePointer();i++){
            assertEquals("A"+i,cb.readData());
        }
        assertFalse(cb.isWriteMorethanBuffer());
    }

    @Test
    public void when_buffer_full_B_overwrite_by_A() {
//        CircularBuffer cb = new CircularBuffer();
        for(int i=0;i< cb.getBufferSize();i++){
            cb.writeData("A"+i);//add
        }
        cb.writeData("B");
        assertEquals("B",cb.readData());

    }

}