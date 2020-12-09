<style>
  @import './assets/styles/custom.css';

</style>

<template>
  <div class="p-grid"> 
    <input class="p-col-2" v-model="words" placeholder="Input words" v-on:keyup.enter="getEntry">
    <button v-on:click="getEntry">Search</button>
  </div> 
      <ul v-if="entries && entries.length">
        <li v-for="entry in entries" :key="entry.word" class="p-col-4">
          <p><strong>{{entry.word}}</strong></p>
          <div v-for="phonetic in entry.phonetics" :key="phonetic.text">
            <p>Phonetic: {{phonetic.text}}</p>
            <button v-on:click="downloadMp3(phonetic.audio)">DownLoad Audio</button>
          </div>

          <div v-for="meaning in entry.meanings" :key="meaning.partOfSpeech">
            <div class="p-d-flex p-flex-column"> 
              <ul>
                <div class="p-mr-2">
                  <li>
                    <p>Part of Speech: {{meaning.partOfSpeech}}</p>
                    <ul v-for="definition in meaning.definitions" :key="definition.definition">
                      <span>
                        <li> <p>Definition: {{definition.definition}}</p> </li>
                        <li v-if="definition.example"> <p>Example: {{definition.example}} </p> </li>
                        <li v-if="definition.synonyms"> <p>Synonyms: {{definition.synonyms}} </p> </li>
                        <hr>
                      </span>
                    </ul>
                  </li>
                </div>
              </ul>
            </div>
            
          </div>
        </li>
      </ul>




  
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
      // JSON responses are automatically parsed.
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
          }

  }
}
</script>