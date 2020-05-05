<#import "parts/pageTemplate.ftl" as pt>
<@pt.page>
    <div class="container mt-5" style="width: 50%">
        <h1>Task #1</h1>

        <div class="form-group mt-3">
            <form action="/firstTask" method="post">
                <div class="form-group">
                    <input type="text" style="width: 500px" name="number"
                           value="" placeholder="Please enter a number">
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
            <label>Result: <#if evenOrOdd??>${evenOrOdd} and ${simpleOrNot}</#if></label>
        </#if>
    </div>

</@pt.page>