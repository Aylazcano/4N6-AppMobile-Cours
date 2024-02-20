package com.example.retrofitsimple;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import android.util.Log;

import com.example.retrofitsimple.http.RetrofitUtil;
import com.example.retrofitsimple.http.Service;

import java.io.IOException;

import model.DoubleResponse;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void multiplication_isCorrect() throws IOException {
        Service service = RetrofitUtil.get();
        Call<DoubleResponse> call = service.getDouble(2);
        Response<DoubleResponse> response = call.execute();

        assertTrue(response.isSuccessful());
        assertNotNull(response.body());

        DoubleResponse result = response.body();


        double expectedResult = 4.0;
        assertEquals(expectedResult, result.getResult(), 0.001); // Vérifie si le résultat est celui attendu avec une marge d'erreur de 0.001
        Log.i("RETROFIT", "Résultat obtenu : " + result.getResult());

        // assertEquals(4, 2 + 2);
    }
}