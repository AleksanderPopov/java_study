package com.alexstudy;

/**
 * Created by Alex on 5/4/2017.
 */
public class Producer implements Runnable {
  // 2. Producers are coupled only to the Mediator
  private Mediator med;
  private int id;
  private static int num = 1;

  public Producer(Mediator m) {
    med = m;
    id = num++;
  }

  @Override
  public void run() {
    int num;
    while (true) {
      med.storeMessage(num = (int)(Math.random()*100));
      System.out.println( "p" + id + "-" + num + "  " );
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
