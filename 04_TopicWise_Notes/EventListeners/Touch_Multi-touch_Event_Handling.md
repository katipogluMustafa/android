# Touch Multi-touch Event Handling

The objective of this chapter is to highlight the handling of touches that
involve motion and to explore the concept of intercepting multiple
concurrent touches.

## Intercepting Touch Events

Touch events can be intercepted by a view object through the registration of
an onTouchListener event listener and the implementation of the
corresponding onTouch() callback method.

* The following code, for example,
ensures that any touches on a ConstraintLayout view instance named
myLayout result in a call to the onTouch() method
````java
myLayout.setOnTouchListener(
      new ConstraintLayout.OnTouchListener() {
          public boolean onTouch(View v, MotionEvent m) {
            // Perform tasks here
            return true;
          }
      });

````

* As indicated in the code example, the onTouch() callback is required to return
a Boolean value indicating to the Android runtime system whether or not the
event should be passed on to other event listeners registered on the same view
or discarded. 
* The method is passed both a reference to the view on which the
event was triggered and an object of type MotionEvent .

## The MotionEvent Object

The MotionEvent object passed through to the onTouch() callback method is
the key to obtaining information about the event. Information contained
within the object includes the location of the touch within the view and the
type of action performed. The MotionEvent object is also the key to handling
multiple touches.

## Understanding Touch Actions

An important aspect of touch event handling involves being able to identify
the type of action performed by the user.

* The type of action associated with
an event can be obtained by making a call to the **getActionMasked()** method
of the MotionEvent object which was passed through to the onTouch()
callback method.

* When the first touch on a view occurs, the MotionEvent
object will contain an action type of **ACTION_DOWN** together with the
coordinates of the touch. 
  * When that touch is lifted from the screen, an
**ACTION_UP** event is generated. 
  * Any motion of the touch between the
ACTION_DOWN and ACTION_UP events will be represented by
**ACTION_MOVE** events.

* When more than one touch is performed simultaneously on a view, the
touches are referred to as pointers. 
  * In a multi-touch scenario, pointers begin
and end with event actions of type **ACTION_POINTER_DOWN** and
**ACTION_POINTER_UP** respectively. 
  * In order to identify the index of the
pointer that triggered the event, the **getActionIndex()** callback method of the
MotionEvent object must be called. 
