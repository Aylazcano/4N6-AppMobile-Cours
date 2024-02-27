package com.example.retrofitsimple;

import android.content.Context;
import android.util.Log;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import com.example.retrofitsimple.http.RetrofitUtil;
import com.example.retrofitsimple.http.Service;

import java.io.IOException;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Test
    public void multiplication_isCorrect() throws IOException {
        Service service = RetrofitUtil.get();
        Call<String> call = service.getDouble(4);
        Response<String> response = call.execute();

        assertTrue(response.isSuccessful());
        assertNotNull(response.body());

        String resultString = response.body();
        int result = Integer.parseInt(resultString);

        int expectedResult = 8;
        assertEquals(expectedResult, result);

        Log.i("RETROFIT", "Résultat obtenu : " + result);
    }
}