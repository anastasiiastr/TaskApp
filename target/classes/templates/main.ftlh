<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
    <div>
        <@l.logout />
    </div>
    <div>
        <form method="post">
            <label>
                <input type="text" name="text" placeholder="Create a task" />
            </label>
            <label>
                <input type="text" name="tag" placeholder="tag">
            </label>
            <button type="submit">Creation</button>
        </form>
    </div>
    <div>List of tasks</div>
    <form method="get" action="/main">
        <label>
            <input type="text" name="filter" value="${filter!}">
        </label>
        <button type="submit">Search</button>
    </form>
    <#list tasks as task>
        <div>
            <b>${task.id!}</b>
            <span>${task.text!}</span>
            <i>${task.tag!}</i>
            <strong>${task.authorName!}</strong>
        </div>
    <#else>
        No task
    </#list>
</@c.page>