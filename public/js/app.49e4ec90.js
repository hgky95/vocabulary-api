(function(e){function t(t){for(var o,a,l=t[0],i=t[1],u=t[2],d=0,s=[];d<l.length;d++)a=l[d],Object.prototype.hasOwnProperty.call(c,a)&&c[a]&&s.push(c[a][0]),c[a]=0;for(o in i)Object.prototype.hasOwnProperty.call(i,o)&&(e[o]=i[o]);p&&p(t);while(s.length)s.shift()();return r.push.apply(r,u||[]),n()}function n(){for(var e,t=0;t<r.length;t++){for(var n=r[t],o=!0,l=1;l<n.length;l++){var i=n[l];0!==c[i]&&(o=!1)}o&&(r.splice(t--,1),e=a(a.s=n[0]))}return e}var o={},c={app:0},r=[];function a(t){if(o[t])return o[t].exports;var n=o[t]={i:t,l:!1,exports:{}};return e[t].call(n.exports,n,n.exports,a),n.l=!0,n.exports}a.m=e,a.c=o,a.d=function(e,t,n){a.o(e,t)||Object.defineProperty(e,t,{enumerable:!0,get:n})},a.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},a.t=function(e,t){if(1&t&&(e=a(e)),8&t)return e;if(4&t&&"object"===typeof e&&e&&e.__esModule)return e;var n=Object.create(null);if(a.r(n),Object.defineProperty(n,"default",{enumerable:!0,value:e}),2&t&&"string"!=typeof e)for(var o in e)a.d(n,o,function(t){return e[t]}.bind(null,o));return n},a.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return a.d(t,"a",t),t},a.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},a.p="/";var l=window["webpackJsonp"]=window["webpackJsonp"]||[],i=l.push.bind(l);l.push=t,l=l.slice();for(var u=0;u<l.length;u++)t(l[u]);var p=i;r.push([0,"chunk-vendors"]),n()})({0:function(e,t,n){e.exports=n("56d7")},"11da":function(e,t,n){},"56d7":function(e,t,n){"use strict";n.r(t);n("e260"),n("e6cf"),n("cca6"),n("a79d");var o=n("7a23"),c=(n("d3b7"),n("ddb0"),Object(o["createVNode"])("h2",null,"Dictionary",-1)),r={class:"input-custom"},a=Object(o["createTextVNode"])(" Search"),l={key:0},i={class:"general"},u={class:"text-left"},p={class:"phonetic"},d={class:"text"},s={class:"padding-right"},b={class:""},f={class:"text-left"},O={class:"shadow"},j={class:"text-left"},y={class:"text-left"},h={class:"text-left"};function g(e,t,n,g,k,v){var m=Object(o["resolveComponent"])("Button");return Object(o["openBlock"])(),Object(o["createBlock"])("section",null,[c,Object(o["createVNode"])("span",r,[Object(o["withDirectives"])(Object(o["createVNode"])("input",{class:"p-col-2","onUpdate:modelValue":t[1]||(t[1]=function(e){return k.word=e}),placeholder:"Input word",onKeyup:t[2]||(t[2]=Object(o["withKeys"])((function(){return v.getEntry.apply(v,arguments)}),["enter"]))},null,544),[[o["vModelText"],k.word]])]),Object(o["createVNode"])(m,{onClick:v.getEntry,class:"pi pi-search p-button-icon"},{default:Object(o["withCtx"])((function(){return[a]})),_:1},8,["onClick"]),k.entries&&k.entries.length?(Object(o["openBlock"])(),Object(o["createBlock"])("ul",l,[(Object(o["openBlock"])(!0),Object(o["createBlock"])(o["Fragment"],null,Object(o["renderList"])(k.entries,(function(e){return Object(o["openBlock"])(),Object(o["createBlock"])("div",{key:e.word},[Object(o["createVNode"])("div",i,[Object(o["createVNode"])("span",u,Object(o["toDisplayString"])(e.word),1),(Object(o["openBlock"])(!0),Object(o["createBlock"])(o["Fragment"],null,Object(o["renderList"])(e.phonetics,(function(e){return Object(o["openBlock"])(),Object(o["createBlock"])("span",{key:e.text},[Object(o["createVNode"])("span",p,[Object(o["createVNode"])("span",d,Object(o["toDisplayString"])(e.text),1),Object(o["createVNode"])(m,{onClick:function(t){return v.doCopy(e.text)},icon:"pi pi-copy",class:"p-button-sm margin-right"},null,8,["onClick"]),Object(o["createVNode"])("label",s,[Object(o["createVNode"])(m,{onClick:function(t){return v.playSound(e.audio)},icon:"pi pi-volume-up",class:"p-button-sm padding-right"},null,8,["onClick"])]),Object(o["createVNode"])("label",null,[Object(o["createVNode"])(m,{onClick:function(t){return v.downloadMp3(e.audio)},icon:"pi pi-download",class:"p-button-sm padding-left"},null,8,["onClick"])])])])})),128))]),(Object(o["openBlock"])(!0),Object(o["createBlock"])(o["Fragment"],null,Object(o["renderList"])(e.meanings,(function(e){return Object(o["openBlock"])(),Object(o["createBlock"])("div",{key:e.partOfSpeech},[Object(o["createVNode"])("div",b,[Object(o["createVNode"])("ul",null,[Object(o["createVNode"])("div",null,[Object(o["createVNode"])("li",null,[Object(o["createVNode"])("p",f," Part of Speech: "+Object(o["toDisplayString"])(e.partOfSpeech),1),(Object(o["openBlock"])(!0),Object(o["createBlock"])(o["Fragment"],null,Object(o["renderList"])(e.definitions,(function(e){return Object(o["openBlock"])(),Object(o["createBlock"])("ul",{key:e.definition},[Object(o["createVNode"])("span",O,[Object(o["createVNode"])("p",j," Definition: "+Object(o["toDisplayString"])(e.definition),1),Object(o["createVNode"])("p",y,"Example: "+Object(o["toDisplayString"])(e.example),1),Object(o["createVNode"])("p",h," Synonyms: "+Object(o["toDisplayString"])(e.synonyms),1)])])})),128))])])])])])})),128))])})),128))])):Object(o["createCommentVNode"])("",!0)])}var k=n("bc3a"),v=n.n(k),m=n("6676"),w="https://dictionary-webapp.herokuapp.com/api/dictionary",V={data:function(){return{entries:[],word:[]}},methods:{getEntry:function(){var e=this,t=w+"?word="+this.word;v.a.get(t).then((function(t){e.entries=t.data})).catch((function(t){alert("Can't found the word: "+e.word),console.log("Error: "+t)}))},downloadMp3:function(e){var t=this,n=w+"/audio";v.a.get(n,{params:{audioUrl:e}}).then((function(e){var t=e.request.responseURL,n=document.createElement("a");n.href=t,n.click()})).catch((function(e){alert("Can't found the word: "+t.word),console.log("Error: "+e)}))},playSound:function(e){var t=new Audio(e);t.play()},doCopy:function(e){Object(m["a"])(e,void 0,(function(e){e&&console.log(e)}))}}};n("e8e9");V.render=g;var N=V,B=(n("bddf"),n("098b"),n("e1ae"),n("4121"),n("65d1")),x=n.n(B),S=n("6549"),C=n.n(S),D=Object(o["createApp"])(N);D.use(x.a),D.component("Button",C.a),D.mount("#app")},e8e9:function(e,t,n){"use strict";n("11da")}});
//# sourceMappingURL=app.49e4ec90.js.map