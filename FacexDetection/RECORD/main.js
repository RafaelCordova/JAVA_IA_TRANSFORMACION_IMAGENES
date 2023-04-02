const video = document.getElementById("video");

function startVideo() {
  navigator.getUserMedia =
    navigator.getUserMedia ||
    navigator.webkitGetUserMedia ||
    navigator.mozGetUserMedia ||
    navigator.mozGetUserMedia;

  navigator.getUserMedia(
    { video: {} },
    (stream) => (video.srcObject = stream),
    (err) => console.log(err)
  );
}

Promise.all([
  faceapi.nets.tinyFaceDetector.loadFromUri("models"),
  faceapi.nets.faceLandmark68Net.loadFromUri("models"),
  faceapi.nets.faceRecognitionNet.loadFromUri("models"),
  faceapi.nets.faceExpressionNet.loadFromUri("models"),
  faceapi.nets.ageGenderNet.loadFromUri("models"),
]).then(startVideo);

video.addEventListener("play", () => {
  const canvas = faceapi.createCanvasFromMedia(video);
  document.body.append(canvas);
  const displaySize = { width: video.width, height: video.height };
  faceapi.matchDimensions(canvas, displaySize);
  setInterval(async () => {
    /* 
        //DETECCION CLASICA
        const detections = await faceapi.detectAllFaces(video, new faceapi.TinyFaceDetectorOptions());
       // console.log(detections);
       //DETECCION AVANZADA
       //const detections = await faceapi.detectAllFaces(video, new faceapi.TinyFaceDetectorOptions()).withFaceLandmarks();
       const resizeDetections = faceapi.resizeResults(detections,displaySize);
       canvas.getContext('2d').clearRect(0,0,canvas.width,canvas.height);
       faceapi.draw.drawDetections(canvas,resizeDetections);
       //ACTIVAR PAR LA AVANZADA
       //faceapi.draw.drawFaceLandmarks(canvas,resizeDetections);
    */

    const detections = await faceapi.detectAllFaces(  video,   new faceapi.TinyFaceDetectorOptions() );
    const resizeDetections = faceapi.resizeResults(detections, displaySize);
    canvas.getContext("2d").clearRect(0, 0, canvas.width, canvas.height);
    resizeDetections.forEach((detection) => drawCircle(canvas, detection));
  }, 100);
});

function drawCircle(canvas, detection) {
  const context = canvas.getContext("2d");
  const x = detection.box.x + detection.box.width / 2;
  const y = detection.box.y + detection.box.height / 2;
  const radius = detection.box.width / 2;
  context.beginPath();
  context.strokeStyle = "blue";
  context.lineWidth = 8;
  context.arc(x, y - 40, radius, 0, 2 * Math.PI);
  context.stroke();
}
