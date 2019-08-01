# The Android Gesture Detector Class

**GestureDetectorCompat** class is designed specifically to receive
motion event information from the application and to trigger method calls
based on the type of common gesture, if any, detected.

The basic steps in detecting common gestures are as follows:

1. Declaration of a class which implements the **GestureDetector.OnGestureListener** interface including the required following callback methods.
    * onFling()
    * onDown()
    * onScroll()
    * onShowPress()
    * onSingleTapUp()
    * onLongPress()
  
  > Note that this can be either an entirely
  new class, or the enclosing activity class. In the event that double tap
  gesture detection is required, the class must also implement the
  **GestureDetector.OnDoubleTapListener** interface and include the
  corresponding **onDoubleTap()** method.  
  
2. Creation of an instance of the Android **GestureDetectorCompat** class,
passing through an instance of the class created in step 1 as an argument. 

3. An optional call to the setOnDoubleTapListener() method of the
GestureDetectorCompat instance to enable double tap detection if
required.

4. Implementation of the onTouchEvent() callback method on the enclosing
activity which, in turn, must call the onTouchEvent() method of the
GestureDetectorCompat instance, passing through the current motion
event object as an argument to the method.

Once implemented, the result is a set of methods within the application code
that will be called when a gesture of a particular type is detected. The code
within these methods can then be implemented to perform any tasks that
need to be performed in response to the corresponding gesture.
