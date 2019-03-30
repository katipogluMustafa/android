# Shared Resources

* Android creates an XML file and stores all the information for us.

````java
    private SharedPreferences myPrefs;                          // We'll use SharedPreferences Class
    private static final String PREFS_NAME = "MyPrefsFile";     // The XML file name
````

* Let's save data with the help of a EditText and Button

````java
saveBtn = findViewById(R.id.saveBtn);
// Put Data
saveBtn.setOnClickListener( v -> {
    myPrefs = getSharedPreferences(PREFS_NAME, 0);
    SharedPreferences.Editor editor = myPrefs.edit();
    editor.putString("message", enterMessage.getText().toString() );
    editor.apply();     // editor.apply() for background write operation
                        // editor.commit() for immediate write operation
});
````

* Let's get the saved data back

````java
// Get Data back
SharedPreferences getPrefs = getSharedPreferences(PREFS_NAME, 0);
if( getPrefs.contains("message") ) {
    String message = getPrefs.getString("message", "Undefined");
    resultView.setText(message);
}
````