<style>
  @import './assets/styles/custom.css';
</style>

<template>
  <section>
        <h2> Dictionary </h2>
        <span class="input-custom"> <input class="p-col-2" v-model="words" placeholder="Input words" v-on:keyup.enter="getEntry"> </span>
        <Button v-on:click="getEntry" class="pi pi-search p-button-icon"> Search</Button>
     
      <ul v-if="entries && entries.length">
        <div v-for="entry in entries" :key="entry.word">
          <div class="general">
              <span class="text-left">{{entry.word}} </span>
              <span v-for="phonetic in entry.phonetics" :key="phonetic.text">
                <span class="phonetic">
                  <span class="text">{{phonetic.text}}</span>
                  <label class="padding-right"> <Button v-on:click="playSound(phonetic.audio)" icon="pi pi-volume-up" class="p-button-sm padding-right"> </Button> </label>
                  <label> <Button v-on:click="downloadMp3(phonetic.audio)" icon="pi pi-download" class="p-button-sm padding-left"> </Button> </label>
                </span>
                
              </span>
          </div>
          

          <div v-for="meaning in entry.meanings" :key="meaning.partOfSpeech">
            <div class=""> 
              <ul>
                <div>
                  <li>
                    <p class="text-left">Part of Speech: {{meaning.partOfSpeech}}</p>
                    <ul v-for="definition in meaning.definitions" :key="definition.definition">
                      <span class="shadow">
                         <p class="text-left">Definition: {{definition.definition}}</p> 
                         <p class="text-left">Example: {{definition.example}} </p> 
                         <p class="text-left">Synonyms: {{definition.synonyms}} </p> 
                      </span>
                    </ul>
                  </li>
                </div>
              </ul>
            </div>
            
          </div>
        </div>
      </ul>
  </section>
  




  
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      entries: [],
      words: []
    }
  },

  methods: {
    getEntry : function () {
      let url = `https://api.dictionaryapi.dev/api/v2/entries/en/` + this.words;
    axios.get(url)
    .then(response => {
      this.entries = response.data
    })
    .catch(e => {
      alert("Can't found the word: " + this.words);
      console("Error: " + e);
      })
    },
    downloadMp3(url) {
              axios({
                    url: 'https://cors-anywhere.herokuapp.com/' + url,
                    method: 'GET',
                    responseType: 'blob',
                }).then((response) => {
                     var fileURL = window.URL.createObjectURL(new Blob([response.data]));
                     var fileLink = document.createElement('a');

                     fileLink.href = fileURL;
                     fileLink.setAttribute('download', this.words + '.mp3');
                     document.body.appendChild(fileLink);

                     fileLink.click();
                });
    },
    playSound(url) {
      var audio = new Audio(url);
      audio.play();
    }

  }
}
</script>