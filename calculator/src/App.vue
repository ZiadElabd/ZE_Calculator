<template>
  <body >
      <div class="grid">
        <div class="screen">{{screen}}</div>
        <button @click="operation('mod')">%</button>
        <button @click="clear">CE</button>
        <button @click="clear">c</button>
        <button @click="deleteNum" class="delete_button">&#8882;</button> 
        <button @click="single_operation('inverse')">1/x</button>
        <button @click="single_operation('pow')">x^2</button>
        <button @click="single_operation('sqrt')">&radic;</button>
        <button @click="operation('div')">&divide;</button>
        <button @click="append('7')">7</button>
        <button @click="append('8')">8</button>
        <button @click="append('9')">9</button>
        <button @click="operation('*')">x</button>
        <button @click="append('4')">4</button>
        <button @click="append('5')">5</button>
        <button @click="append('6')">6</button>
        <button @click="operation('-')">-</button>
        <button @click="append('1')">1</button>
        <button @click="append('2')">2</button>
        <button @click="append('3')">3</button>
        <button @click="operation('+')">+</button>
        <button @click="changeSign">+/-</button>
        <button @click="append('0')">0</button>
        <button @click="append('.')">.</button>
        <button @click="equal" class="equal_button">=</button>
      </div>
  </body>
</template>


<script>
export default {
    name: 'App',
    data() {
        return {
            result: 0,
            screen: '0',
            operator:'+',
        };
    },
    methods: {
        append(num){
          if(this.screen == '0') this.screen = num+""
          else  this.screen += num;
            
        },
        deleteNum(){
            let length = this.screen.length;
            this.screen = this.screen.substring(0,length-1);
        },
        async operation(operator){
            this.result = await this.fetchOperation(this.result,this.operator,this.screen);
            this.screen='';
            this.operator=operator;
        },
        async single_operation(operator){
            this.result = await this.fetchOperation(this.result,this.operator,this.screen);
            this.screen='';
            fetch("http://localhost:9000/"+this.result+'/'+operator ,{method:"get"})
            .then(response =>{
                return response.json()
            })
            .then(data =>{
                this.screen = data+""
            });
            this.operator='+';
            this.result=0;
        },
        clear(){
            this.result='0';
            this.screen='';
            this.operator='+';
        },
        async equal(){
            this.screen = await this.fetchOperation(this.result,this.operator,this.screen);
            this.result = 0;
            this.operator='+';
        },
        async changeSign(){
            this.screen = await this.fetchOperation(this.screen,'*','-1');
        },
        async fetchOperation(num1,operator,num2){
          var result = 0;
          await fetch("http://localhost:9000/"+num1+'/'+operator +'/'+num2,{method:"get"})
            .then(response =>{
              console.log('ngf');
                return response.json()
            })
            .then(data =>{
              console.log('ngf');
                result = data+"" 
            });
            return result;
        }
    }
        
}
  

</script>


<style>
  body {
      background-color: #4997d0;
  }
  .grid{
      margin-top: 15%;
      display: grid;
      justify-content: center;
      align-content: center;
      grid-template-columns: repeat(4, 75px);
      grid-template-rows: repeat(7, 75px);

  }
  button{
      width: 75px;
      height: 75px;
      border-radius: 20%;
      border: 1px solid #4997d0;
      font: 2em  Monospace;
      cursor: pointer;
      outline: none;
  }
  button:hover {
      background-color: #dbd7d2;
  }
  .screen{
      height: 75px;
      grid-column: 1/-1;
      background-color: black;
      color: white;
      font-size: 50px;
      display: flex;
      align-items: flex-end;
      flex-direction: column;
  }
  .delete_button{
      background-color: red;
  }
  .equal_button{
      background-color: rgb(98, 98, 240);
  }
</style>
