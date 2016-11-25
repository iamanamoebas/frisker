package za.koding.frisker;

import za.koding.frisker.lib.ApplicationPattern;
import za.koding.frisker.lib.HTTPManager;
import android.content.Context;
import android.util.DisplayMetrics;
import android.graphics.drawable.Drawable;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.Canvas;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * The Application class for Frisker. Provides a static reference to the
 * {@link za.koding.frisker.lib.HTTPManager},
 * as well as stores the application's "secret" key.
 */
public class Application extends ApplicationPattern {
  /**
   * A private static reference to the HTTP Manager.
   */
  private static final HTTPManager httpManager = new HTTPManager();

  /**
   * Called when the application is run.
   */
  public void onCreate() {
    super.onCreate();

    context = getApplicationContext();

    char[] secret = {
      'a', 'a', '8', 'c', 'f', '9', '7', '4', '8', '2', 'b', '1', 'b', '1', '3', '6', '5', '6', '8',
      '3', 'c', '6', '4', '4', 'c', 'f', '9', 'c', '3', '9', 'e', '9'
    };

    setSharedPrefs(secret);
  }

  /**
   * A public "getter" method for the HTTP manager
   */
  public static HTTPManager getHttpManager() {
    return httpManager;
  }

  /**
   * Given a "Density Pixel" value, converts it to a corresponding PX value for the
   * current device
   *
   * @param dp The "DP" value to convert
   * @param context The context from which the call was made
   * @return A {@link float} PX value
   */
  public static float dpToPx(float dp, Context context) {
    return dp
        * ((float) context.getResources().getDisplayMetrics().densityDpi
            / DisplayMetrics.DENSITY_DEFAULT);
  }

  /**
   * Given a Drawable and some file name, converts the drawable to a Bitmap and saves
   * it to disk in the "images" directory. Note: The returned File may be "null".
   *
   * @param drawable The drawable to save
   * @param fileName The name of the file to save in the "images" directory. Name should include the
   *                 extension.
   * @return A (potentially null) File indicating where the image was saved
   */
  public static File drawableToFile(Drawable drawable, String fileName) {
    if (drawable == null || fileName == null) {
      Log.i("DRAWABLE-TO-FILE", "Given Drawable was null, so returning null File");
      return null;
    }

    Bitmap bitmap = null;

    if (drawable instanceof BitmapDrawable) {
      BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
      if (bitmapDrawable.getBitmap() != null) {
        bitmap = bitmapDrawable.getBitmap();
      }
    } else {
      // Create a Bitmap from the drawable
      bitmap =
          Bitmap.createBitmap(
              drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
      Canvas canvas = new Canvas(bitmap);
      drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
      drawable.draw(canvas);
    }

    Bitmap.CompressFormat format;

    if (fileName.length() >= 5 && fileName.substring(fileName.length() - 3) == "jpg") {
      format = Bitmap.CompressFormat.JPEG;
    } else {
      format = Bitmap.CompressFormat.PNG;
    }

    File directory =
        new File(Environment.getExternalStorageDirectory() + File.separator + "images");

    File file = new File(directory, fileName);

    FileOutputStream outputStream = null;

    try {
      outputStream = new FileOutputStream(file);
      bitmap.compress(format, 100, outputStream);
      outputStream.close();
      return file;
    } catch (IOException e) {
      Log.e("DRAWABLE-TO-FILE", "Unable to save the provided drawable to disk.", e);
      if (outputStream != null) {
        try {
          outputStream.close();
        } catch (IOException e1) {
          Log.e("DRAWABLE-TO-FILE", "Unable to close file output stream.", e);
        }
      }
      return null;
    }
  }
}