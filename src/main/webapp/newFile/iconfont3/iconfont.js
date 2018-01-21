;(function(window) {

  var svgSprite = '<svg>' +
    '' +
    '<symbol id="icon-wxbgongju" viewBox="0 0 1024 1024">' +
    '' +
    '<path d="M944.140673 718.412117 621.322359 452.362738c17.037025-37.017078 26.009374-77.727269 26.009374-118.662587 0-156.206668-127.07007-283.313577-283.313577-283.313577-28.04473 0-55.711859 3.996011-82.250282 12.062733l-30.853705 9.348925 175.299515 175.355797c7.463995 7.388271 11.496845 17.265222 11.496845 27.819602s-4.03285 20.430308-11.496845 27.894304l-92.992951 93.030813c-14.815427 14.776542-40.879036 14.852266-55.712883 0L102.189915 220.615607l-9.329483 30.758538c-8.066723 26.612101-12.156878 54.281277-12.156878 82.324984 0 156.131967 127.10691 283.239899 283.314601 283.239899 41.011043 0 81.684394-8.894577 118.662587-25.934672L623.357715 763.344468c0.678452 2.712785 1.811252 5.276167 3.618411 7.537673 1.88493 2.411933 4.297886 4.222161 6.935969 5.429663l113.687272 139.242298c14.175861 16.512069 34.529421 26.086122 55.789631 26.086122 19.525706 0 38.035268-7.841595 52.169173-21.937638l93.02979-93.030813c14.927991-14.927991 22.691815-34.45472 21.86396-54.958706C969.696722 751.207034 960.462406 732.358757 944.140673 718.412117M921.297408 799.380196l-93.030813 93.030813c-14.399965 14.32424-38.373982 13.269211-51.076282-1.658779l-53.714366-65.739237 64.685231-52.16815c8.329712-6.710842 9.572006-18.922978 2.938935-27.215852-6.710842-8.292873-18.847254-9.574053-27.140127-2.939959l-64.910359 52.393277-28.271904-34.6778 58.126862-46.89403c8.292873-6.708795 9.612938-18.845207 2.865257-27.139104-6.634094-8.367575-18.810415-9.650801-27.102265-2.939959l-58.31208 47.043433L492.783845 542.377868l-13.94664 7.388271c-35.132148 18.771529-74.786287 28.572756-114.818025 28.572756-134.947482 0-244.714468-109.692285-244.714468-244.639766 0-12.966313 0.998747-25.7822 2.996241-38.44766l127.917368 127.935788c29.345352 29.40061 80.930217 29.40061 110.295012 0l92.992951-93.030813c14.737656-14.70184 22.806425-34.302247 22.806425-55.184857 0-20.806885-8.068769-40.48404-22.806425-55.110155L325.607334 91.925642c12.664438-1.960655 25.51921-2.940982 38.410821-2.940982 134.947482 0 244.714468 109.691261 244.714468 244.713444 0 39.957037-9.874905 79.687924-28.572756 114.742301l-7.388271 13.947663L919.336754 747.9652c7.728008 6.634094 12.215206 15.60542 12.552897 25.25622C932.30409 782.870174 928.497391 792.145421 921.297408 799.380196"  ></path>' +
    '' +
    '</symbol>' +
    '' +
    '</svg>'
  var script = function() {
    var scripts = document.getElementsByTagName('script')
    return scripts[scripts.length - 1]
  }()
  var shouldInjectCss = script.getAttribute("data-injectcss")

  /**
   * document ready
   */
  var ready = function(fn) {
    if (document.addEventListener) {
      if (~["complete", "loaded", "interactive"].indexOf(document.readyState)) {
        setTimeout(fn, 0)
      } else {
        var loadFn = function() {
          document.removeEventListener("DOMContentLoaded", loadFn, false)
          fn()
        }
        document.addEventListener("DOMContentLoaded", loadFn, false)
      }
    } else if (document.attachEvent) {
      IEContentLoaded(window, fn)
    }

    function IEContentLoaded(w, fn) {
      var d = w.document,
        done = false,
        // only fire once
        init = function() {
          if (!done) {
            done = true
            fn()
          }
        }
        // polling for no errors
      var polling = function() {
        try {
          // throws errors until after ondocumentready
          d.documentElement.doScroll('left')
        } catch (e) {
          setTimeout(polling, 50)
          return
        }
        // no errors, fire

        init()
      };

      polling()
        // trying to always fire before onload
      d.onreadystatechange = function() {
        if (d.readyState == 'complete') {
          d.onreadystatechange = null
          init()
        }
      }
    }
  }

  /**
   * Insert el before target
   *
   * @param {Element} el
   * @param {Element} target
   */

  var before = function(el, target) {
    target.parentNode.insertBefore(el, target)
  }

  /**
   * Prepend el to target
   *
   * @param {Element} el
   * @param {Element} target
   */

  var prepend = function(el, target) {
    if (target.firstChild) {
      before(el, target.firstChild)
    } else {
      target.appendChild(el)
    }
  }

  function appendSvg() {
    var div, svg

    div = document.createElement('div')
    div.innerHTML = svgSprite
    svgSprite = null
    svg = div.getElementsByTagName('svg')[0]
    if (svg) {
      svg.setAttribute('aria-hidden', 'true')
      svg.style.position = 'absolute'
      svg.style.width = 0
      svg.style.height = 0
      svg.style.overflow = 'hidden'
      prepend(svg, document.body)
    }
  }

  if (shouldInjectCss && !window.__iconfont__svg__cssinject__) {
    window.__iconfont__svg__cssinject__ = true
    try {
      document.write("<style>.svgfont {display: inline-block;width: 1em;height: 1em;fill: currentColor;vertical-align: -0.1em;font-size:16px;}</style>");
    } catch (e) {
      console && console.log(e)
    }
  }

  ready(appendSvg)


})(window)