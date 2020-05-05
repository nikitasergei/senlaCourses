<#import "parts/pageTemplate.ftl" as pt>
<@pt.page>
    <div class="container mt-5" style="width: 50%">
        <h1>Task #3</h1>

        <div class="form-group mt-3">
            <form action="/fourthTask" method="post">
                <div class="form-group">
                    <input type="text" style="width: 500px" name="text"
                           value="" placeholder="Please enter a sentence">
                </div>
                <div class="form-group">
                    <input type="text" style="width: 500px" name="word"
                           value="" placeholder="Please enter a word">
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
            <label>Word number: <#if count??>${count}</#if></label>
        </#if>
    </div>

</@pt.page>