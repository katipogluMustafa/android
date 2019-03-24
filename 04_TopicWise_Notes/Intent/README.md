# Intent

## Send

```java
    Intent intent = new Intent(MainActivity.this,AppConnectActivity.class);
    intent.putExtra("msg", "Hello From First Activity!\n");
    intent.putExtra("msg2", "What's up ?\n");
    startActivity(intent);
```

## Get

```java
    Bundle bundle = getIntent().getExtras();
    if( bundle != null ){
        msg = bundle.getString("msg");
        msg2 = bundle.getString("msg2", "Default msg if you want fallback");
    }
```

### Details

* You may want to get something as return from the intent you send 
  * Inside Second Activity send the result you want and if you want you can add intent and extra data too.
    ```java
      backBtn = findViewById(R.id.backBtn);
      backBtn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent returnIntent = getIntent();
              returnIntent.putExtra("returnData", "From Second Activity");
              setResult(RESULT_OK, returnIntent);
              finish();
          }
      });
    ```
  * Inside First Activity, let's get the result and any extra if exists
     ```java
    private Button startBtn;
    /*
     * Request code for the number of the intent, 
     * let's say you start 10 different intent, you give each one of them different request code so that when you receive them inside onActivityResult method, 
     * you can check whether you get the appropriate one or not...
     */
     private final int REQUEST_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startBtn = findViewById(R.id.main_startBtn);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AppConnectActivity.class);
                intent.putExtra("msg", "Hello From First Activity!\n");
                intent.putExtra("msg2", "What's up ?\n");
                // Be careful, you can't just start you start for result in this case, since the intent we send will return somethings back to us
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String result;
        if( requestCode == REQUEST_CODE )
            if( resultCode == RESULT_OK )
                if( data != null) {
                    result = data.getStringExtra("returnData");
                    Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
                }
    }
    ``` 

* You can finish the activity you are sending the intent

```java
    // This way we say we are done with the activity and it will be closed, no returning back
    finish();                   
```
