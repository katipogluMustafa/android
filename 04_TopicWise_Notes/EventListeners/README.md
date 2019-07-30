# Android Event Listeners

* <i>onClickListener</i>
  * Used to detect click style events whereby the user
touches and then releases an area of the device display occupied by a
view. 
  * Corresponds to the onClick() callback method which is passed a
reference to the view that received the event as an argument.

* <i>onLongClickListener</i>
  * Used to detect when the user maintains the
touch over a view for an extended period. 
  * Corresponds to the
onLongClick() callback method which is passed as an argument the
view that received the event.

* <i>onTouchListener</i> 
  * Used to detect any form of contact with the touch
screen including individual or multiple touches and gesture motions.
Corresponding with the onTouch() callback
  * The callback method is passed as arguments the
view that received the event and a MotionEvent object.

* <i>onCreateContextMenuListener</i> 
  * Listens for the creation of a context
menu as the result of a long click. 
  * Corresponds to the
onCreateContextMenu() callback method. The callback is passed the
menu, the view that received the event and a menu context object.

* <i>onFocusChangeListener</i> 
  * Detects when focus moves away from the
current view as the result of interaction with a track-ball or navigation
key. 
  * Corresponds to the onFocusChange() callback method which is
passed the view that received the event and a Boolean value to indicate
whether focus was gained or lost.

* <i>onKeyListener</i>
  * Used to detect when a key on a device is pressed while
a view has focus. 
  * Corresponds to the onKey() callback method. Passed
as arguments are the view that received the event, the KeyCode of the
physical key that was pressed and a KeyEvent object.
