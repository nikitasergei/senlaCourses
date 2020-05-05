<#import "parts/pageTemplate.ftl" as pt>
<@pt.page>
    <div class="container mt-5" style="width: 50%">
        <h1>Task #2</h1>

        <div class="form-group mt-3">
            <form action="/secondTask" method="post">
                <div class="form-group">
                    <input type="text" style="width: 500px" name="number1"
                           value="" placeholder="Please enter first number">
                </div>
                <div class="form-group">
                    <input type="text" style="width: 500px" name="number2"
                           value="" placeholder="Please enter the second number">
                </div>
                <div class="form-group mt-2">
                    <input type="submit" class="btn btn-primary" value="Submit">
                </div>
            </form>
        </div>
        <#if exception??>
            <div class="alert alert-${messageType}" role="alert">
                ${exception}
            </div>
        <#else>
            <label><#if nok??>Nok is: ${nok} <br> Nod is:${nod}</#if></label>
        </#if>
    </div>

</@pt.page>