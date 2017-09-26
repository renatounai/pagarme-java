package unit;

import me.pagar.generickeyvalueobject.QueriableParameters;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by henriquekano on 9/25/17.
 */
public class QueryParametersTest {

    private QueriableParameters testSubject = new QueriableParameters();
    {
        testSubject.equals("equalsInt", 1);
        testSubject.notEquals("notEqualsInt", 2);
        testSubject.moreThan("moreThanInt", 3);
        testSubject.moreThanOrEquals("moreThanOrEqualsInt", 4);
        testSubject.lessThan("lessThanInt", 5);
        testSubject.lessThanOrEquals("lessThanOrEqualsInt", 6);

        testSubject.equals("equalsString", "a");
        testSubject.notEquals("notEqualsString", "b");
        testSubject.moreThan("moreThanString", "c");
        testSubject.moreThanOrEquals("moreThanOrEqualsString", "d");
        testSubject.lessThan("lessThanString", "e");
        testSubject.lessThanOrEquals("lessThanOrEqualsString", "f");

        testSubject.equals("equalsBoolean", true);
        testSubject.notEquals("notEqualsBoolean", true);

    }

    @Test
    public void testQueryParameterConvertion() {
        String queryParams = testSubject.toQueryString();
        List<String> params = Arrays.asList(queryParams.split("&"));

        List<String> expectedParams = Arrays.asList(new String[] {"equalsInt=1",
                "notEqualsInt=!=2",
                "moreThanInt=>3",
                "moreThanOrEqualsInt=>=4",
                "lessThanInt=<5",
                "lessThanOrEqualsInt=<=6",
                "equalsString=a",
                "notEqualsString=!=b",
                "moreThanString=>c",
                "moreThanOrEqualsString=>=d",
                "lessThanString=<e",
                "lessThanOrEqualsString=<=f",
                "equalsBoolean=true",
                "notEqualsBoolean=!=true"});

        Assert.assertTrue(params.containsAll(expectedParams));
    }
}
