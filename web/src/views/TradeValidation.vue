<template>
    <div class="trade-validation">
        <div class="row">
            <div class="col-12">
               <textarea
                 class="form-control"
                 rows="10"
                 v-model="tradeData"
                 placeholder="Данные..."></textarea>
                <button @click="validate()" class="btn btn-primary">
                  Validate
                </button>
            </div>
            <div class="col-12">
              <div class="card-trade"
                   v-for="(error, index) in errors"
                   :key="index">
                <div class="row">
                  <div class="col-8">
                    <pre>{{error.trade}}</pre>
                    <br>
                    <ul>
                      <li v-for="(message, index) in error.messages"
                          :key="index">
                        <b>{{message.code}}: </b>
                        <span style="color: red">{{ message.message }}</span>
                      </li>
                    </ul>
                    <hr>
                  </div>
                </div>
              </div>
            </div>
        </div>
        <loading :is-loading="isProcessing"></loading>
    </div>
</template>

<script>
import TradeService from '@/common/services/trade.service'
import NotificationService from '@/common/notification.service'
import Loading from '@/components/Loading'


export default {
    name: "trade-validate",
    components: {
        Loading
    },
    data () {
        return {
            tradeData: "",
            errors: [],
            isProcessing: false,
            trades: []
        }
    },
    mounted() {
    },
    methods: {
        validate() {
            this.trades = JSON.parse(this.tradeData)
            this.isProcessing = true
            TradeService.validate(this.trades)
                .then((resp) => {
                    if (resp.data.responseInfo) {
                        this.errors = resp.data.responseInfo.errors
                    }
                },
                (error) => {
                    this.isProcessing = false
                    NotificationService.error(this, "Server error")
                });
        }
    }
};
</script>

<style lang="scss">

  .trade-validation {
    margin: 50px;
  }

  textarea {
    padding: 10px;
    width: 100%;
  }

</style>
