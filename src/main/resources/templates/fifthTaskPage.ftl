<#import "parts/pageTemplate.ftl" as pt>
<@pt.page>
    <div class="container mt-5" style="width: 50%">
        <h1>Task #5</h1>

        <div class="form-group mt-3">
            <form action="/fifthTask" method="post">
                <div class="form-group">
                    <input type="text" style="width: 500px" name="length"
                           value="" placeholder="Please enter sequence's length">
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
            <label>Sequence contains: <#if count??>${count} palindromes</#if></label>
        </#if>
    </div>

</@pt.page>