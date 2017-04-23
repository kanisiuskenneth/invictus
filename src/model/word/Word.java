package model.word;

import java.awt.*;

import util.Pair;

/**
 * File: Word.java
 * Author: 13515063 - Kezia Suhendra
 */

/**
 * Kelas Word.
 */
public class Word {
  private String content;
  private Pair<Integer, Integer> position;

  /**
   * Constructor.
   *
   * @param content atau word yang akan muncul.
   */

  public Word(String content) {
    this.content = content;
  }

  /**
   * Getter content.
   * @return content dari word.
   */
  public String getContent() {
    return content;
  }

  /**
   * Getter position.
   * @return position dari word.
   */
  public Pair<Integer, Integer> getPosition() {
    return position;
  }

  /**
   * Setter position.
   * @param position dari word.
   */
  public void setPosition(Pair<Integer, Integer> position) {
    this.position = position;
  }
}
