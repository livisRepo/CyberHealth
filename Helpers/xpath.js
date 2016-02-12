/**
 * Created by ADMIN on 05-02-2016.
 */

exports.getPathTo=function(element) {

    it('To get Xpath', function () {

        // only generate xpaths for elements which contain a particular text:
        if (element.innerText == "MakeGoodDisabled-Programwise_09_44_38_461(n)") {

            // use id to produce relative paths rather than absolute, whenever possible
            if ((element.id !== '') && (element.id != 'undefined')) {
                return 'id(\"' + element.id + '\")';
            }

            // stop looping when you get to the body tag
            if (element === document.body) {
                return element.tagName;
            }

            // calculate position among siblings
            var ix = 0;
            var siblings = element.parentNode.childNodes;
            for (var i = 0; i < siblings.length; i++) {
                var sibling = siblings[i];
                if (sibling === element) {
                    return getPathTo(element.parentNode) + '/' + element.tagName + '[' + (ix + 1) + ']';
                }
                if (sibling.nodeType === 1 && sibling.tagName === element.tagName) {
                    ix++;
                }
            }
        }


// put all matching xpaths in an array
        var allXPaths = [];

// if you know the particular tag you are looking for, replace * below to optimize
        var allTags = document.getElementsByTagName('*');
        for (i = 0; i < allTags.length; i++) {
            if ((getPathTo(allTags[i]).indexOf('/HEAD') == -1) && (getPathTo(allTags[i]).indexOf('undefined') == -1)) {
                allXPaths.push(getPathTo(allTags[i]));
                console.log(getPathTo(allTags[i]));

            }

        }
        console.log('aaaaaaaaaaaaaaaaaaaaaaaaaaaa');
        return allXPaths;
    });
}