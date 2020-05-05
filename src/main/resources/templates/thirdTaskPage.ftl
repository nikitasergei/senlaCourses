<#import "parts/pageTemplate.ftl" as pt>
<@pt.page>
    <div class="container mt-5" style="width: 50%">
        <h1>Task #3</h1>

        <div class="form-group mt-3">
            <form action="/thirdTask" method="post">
                <div class="form-group">
                    <input type="text" style="width: 500px" name="text"
                           value="" placeholder="Please enter a sentense">
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
            <label>Word number: <#if wordNumber??>${wordNumber} </#if></label><br>
            <label>Sorted word order: <#if sortWord??>
                    <#list sortWord as word>${word}, </#list>
                </#if></label><br>
            <label>Word to Uppercase: <#if uppercaseWords??><#list uppercaseWords as word>${word}, </#list>
                </#if></label>
        </#if>
    </div>

</@pt.page>